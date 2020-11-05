package bussiness.custom;

import bussiness.SuperBO;
import util.CustomTM;
import util.Issue_BookTM;
import util.ReturnsTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface IssueAndReturnsBO extends SuperBO {

    public String getNewIssueID() throws Exception;

    public boolean returnBooks(List<ReturnsTM> issueList) throws Exception;
    public boolean updatepaymentForLate(List<ReturnsTM> issueList, Date returnDate) throws Exception;

    public CustomTM  getToReturnBooksByBookID(String bookID)throws Exception;

    public List<CustomTM>  getToReturnBooksByMemberID(String memberID)throws Exception;

    public double calDalaypayments (String memberCategory, Date returnDate)throws Exception;

    public boolean issuebook(List<Issue_BookTM> issue_bookTMS) throws Exception;

}
