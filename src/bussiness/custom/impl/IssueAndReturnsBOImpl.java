package bussiness.custom.impl;

import Entity.CustomEntity;
import Entity.Issue_Book;
import bussiness.custom.IssueAndReturnsBO;
import dao.DAOFActory;
import dao.DAOType;
import dao.custom.Issue_BookDAO;
import dao.custom.QueryDAO;
import dao.custom.ReturnsDAO;
import util.CustomTM;
import util.CustomTM2;
import util.Issue_BookTM;
import util.ReturnsTM;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IssueAndReturnsBOImpl implements IssueAndReturnsBO {

    private QueryDAO queryDAO= DAOFActory.getInstance().getDAO(DAOType.QUERRY);
    private Issue_BookDAO issueBookDAO= DAOFActory.getInstance().getDAO(DAOType.ISSUE_BOOK);
    private ReturnsDAO returnsDAO=DAOFActory.getInstance().getDAO(DAOType.RETURNS);

    @Override
    public String getNewIssueID() throws Exception {
        String lastBookID = issueBookDAO.getLastIssueID();

        if (lastBookID == null) {
            return "I001";
        } else {
            int maxId = Integer.parseInt(lastBookID.replace("I", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "I00" + maxId;
            } else if (maxId < 100) {
                id = "I0" + maxId;
            } else {
                id = "I" + maxId;
            }
            return id;
        }
    }

    @Override
    public boolean returnBooks(List<ReturnsTM> issueList) throws Exception {
        boolean result=false;
        Iterator<ReturnsTM> iterator = issueList.iterator();
        while (iterator.hasNext()){
            ReturnsTM item=iterator.next();
            System.out.println("In BOImpl send data toDAO -->"+item.getIssueNo()+","+item.getBookID());
            result= returnsDAO.deleteRecord(item.getIssueNo(),item.getBookID());
            if (!result) break;
        }
        return result;
    }

    @Override
    public boolean updatepaymentForLate(List<ReturnsTM> issueList, Date returnDate) throws Exception {
        boolean result=false;
        Iterator<ReturnsTM> iterator = issueList.iterator();
        while (iterator.hasNext()){
            ReturnsTM item=iterator.next();
            result=  issueBookDAO.updateDate(item.getIssueNo(),returnDate);
            if (!result) break;
        }
        return result;
    }

    @Override
    public CustomTM getToReturnBooksByBookID(String bookID) throws Exception {

        System.out.println("Executed BO-->"+bookID);

        CustomEntity customTMS= queryDAO.getToReturnBooksByBookID(bookID);

        double latefee =calDalaypayments(customTMS.getmType(),customTMS.getReturnDate());

        return new CustomTM(customTMS.getMemberID(),customTMS.getmName(),customTMS.getmType(),customTMS.getIssueNo(),customTMS.getBookID(),customTMS.getbName(),latefee);
    }
    @Override
    public List<CustomTM> getToReturnBooksByMemberID(String memberID) throws Exception {

       List<CustomEntity>  customTMS= queryDAO.getToReturnBooksByMemberID(memberID);
        List<CustomTM>  customTMS2=new ArrayList<CustomTM>();
        for (CustomEntity customEntity:customTMS) {
            double latefee =calDalaypayments(customEntity.getmType(),customEntity.getReturnDate());
            customTMS2.add(new CustomTM(customEntity.getMemberID(),customEntity.getmName(),customEntity.getmType(),customEntity.getIssueNo(),customEntity.getBookID(),customEntity.getbName(),latefee));
        }
        System.out.println(customTMS2);
        return customTMS2;
    }
    @Override
    public double calDalaypayments(String memberCategory, Date returnDate) throws Exception {
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());

        double chargesForOneDay=0;

        if (memberCategory.equals("Free")){ chargesForOneDay=10; }
        if (memberCategory.equals("Bronze")){ chargesForOneDay=8; }
        if (memberCategory.equals("Silver")){ chargesForOneDay=7; }
        if (memberCategory.equals("Gold")){ chargesForOneDay=6; }
        if (memberCategory.equals("Platinum")){ chargesForOneDay=5; }

        if (currentDate.after(returnDate)){

            long difference = currentDate.getTime() - returnDate.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            double days=daysBetween;
            return chargesForOneDay*days;
        }
        return 0;
    }

    @Override
    public boolean issuebook(List<Issue_BookTM> issue_bookTMS) throws Exception {
        boolean result=false;

        for (Issue_BookTM issue_bookTM:issue_bookTMS) {
            result= issueBookDAO.save(new Issue_Book(issue_bookTM.getIssueNo(),
                    issue_bookTM.getBookID(),
                    issue_bookTM.getMemberID(),
                    issue_bookTM.getIssueDate(),
                    issue_bookTM.getReturnDate(),
                    issue_bookTM.getIssueStaffID()));
            if(result==false) break;
        }

        return result;
    }
}
