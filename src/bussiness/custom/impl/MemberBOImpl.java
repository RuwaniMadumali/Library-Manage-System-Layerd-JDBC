package bussiness.custom.impl;

import Entity.Book;
import bussiness.MemberSearchType;
import bussiness.custom.MemberBO;
import dao.DAOFActory;
import dao.DAOType;
import dao.custom.BookDAO;
import dao.custom.MemberDAO;
import util.BookT;
import util.BookTM;
import util.Member;
import util.MemberTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MemberBOImpl implements MemberBO {

    private MemberDAO memberDAO = DAOFActory.getInstance().getDAO(DAOType.MEMBER);



    @Override
    public Member getSingleMemberByAll(MemberSearchType memberSearchType, String value) throws Exception {

        Entity.Member singlemember;

        switch (memberSearchType){
            case MEMBER_ID:{
                singlemember=memberDAO.find(value);
                return new Member(singlemember.getMemberID(),singlemember.getMemberNIC(),singlemember.getmName(),singlemember.getmAddress(),singlemember.getmEmail(),singlemember.getGender(),singlemember.getmPhoneNo(),singlemember.getmType(),singlemember.getmExpDate());
            }
            case MEMBER_NAME:{
                singlemember=memberDAO.findByMemberName(value);
                return new Member(singlemember.getMemberID(),singlemember.getMemberNIC(),singlemember.getmName(),singlemember.getmAddress(),singlemember.getmEmail(),singlemember.getGender(),singlemember.getmPhoneNo(),singlemember.getmType(),singlemember.getmExpDate());
            }
            case MEMBER_NIC:{
                singlemember=memberDAO.findByMemberNIC(value);
                return new Member(singlemember.getMemberID(),singlemember.getMemberNIC(),singlemember.getmName(),singlemember.getmAddress(),singlemember.getmEmail(),singlemember.getGender(),singlemember.getmPhoneNo(),singlemember.getmType(),singlemember.getmExpDate());
            }
            default:{
                return  null;
            }
        }
    }

    @Override
    public String getNewMemberID() throws Exception {
        String lastMemberID = memberDAO.getLastMemberID();

        if (lastMemberID == null) {
            return "M001";
        } else {
            int maxId = Integer.parseInt(lastMemberID.replace("M", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "M00" + maxId;
            } else if (maxId < 100) {
                id = "M0" + maxId;
            } else {
                id = "M" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<MemberTM> getAllMembers() throws Exception {
        List<Entity.Member> allMembers = memberDAO.findAll();
        List<MemberTM> members = new ArrayList<>();
        for (Entity.Member member : allMembers) {
            members.add(new MemberTM(member.getMemberID(),member.getMemberNIC(),member.getmName(),member.getGender(),member.getmType(),member.getmAddress(),member.getmEmail(),member.getmPhoneNo(),member.getmAddDate(),member.getmExpDate()));
        }
        return members;
    }

    @Override
    public MemberTM getSingleMember(String memberID) throws Exception {
        Entity.Member singlemember=memberDAO.find(memberID);
        MemberTM member = new MemberTM(singlemember.getMemberID(),singlemember.getMemberNIC(),singlemember.getmName(),singlemember.getmType(),singlemember.getmAddress(),singlemember.getmEmail(),singlemember.getGender(),singlemember.getmPhoneNo(),singlemember.getmAddDate(),singlemember.getmExpDate());
        return member;
    }

    @Override
    public List<Member> CountPercentageMemberCategoryWise() throws Exception {
        List<Entity.Member> allMembers = memberDAO.getCountMemberCategoryWise();
        List<Member> members = new ArrayList<>();
        List<Integer> allCount=new ArrayList<>();
        for (Entity.Member member : allMembers) {
            allCount.add(member.getCount());
            members.add(new Member(member.getmType(),member.getCount()));
        }
        return members;
    }

    @Override
    public List<Member> getfewMemberDetails() throws Exception {
        List<Entity.Member> allMembers = memberDAO.findfewAll();
        List<Member> members = new ArrayList<>();
        for (Entity.Member member : allMembers) {
            //id nic name address email gender contactNo category expdate button
            members.add(new Member(member.getMemberID(),member.getMemberNIC(),member.getmName(),member.getmAddress(),member.getmEmail(),member.getGender(),member.getmPhoneNo(),member.getmType(),member.getmExpDate()));
        }
        return members;
    }

    @Override
    public boolean updateCategory(String id, String valueid,Date expdate) throws Exception {
        return memberDAO.updateMembership(id,valueid,expdate);
    }

    @Override
    public boolean saveMember(String memberID, String memberNIC, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExpDate) throws Exception {
        return memberDAO.save(new Entity.Member(memberID,memberNIC,mName,mType,mAddress,mEmail,gender,mPhoneNo, mAddDate,mExpDate));
    }

    @Override
    public boolean deleteMember(String memberID) throws Exception {
        return memberDAO.delete(memberID);
    }

    @Override
    public boolean updateMember(String memberNIC,String mName,String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExpDate, String memberID) throws Exception {
        return memberDAO.update(new Entity.Member(memberID,memberNIC,mName,mType,mAddress,mEmail,gender,mPhoneNo, mAddDate,mExpDate));
    }
    @Override
    public boolean updateMemberWithoutAddDate(String memberNIC, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mExpDate, String memberID) throws Exception {
        return memberDAO.updateMember(new Entity.Member(
                memberID,memberNIC,mName,mAddress,mEmail,gender,mPhoneNo,mType,mExpDate));

    }
}
