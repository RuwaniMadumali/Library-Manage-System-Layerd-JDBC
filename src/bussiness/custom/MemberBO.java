package bussiness.custom;




import bussiness.BookSearchType;
import bussiness.MemberSearchType;
import bussiness.SuperBO;
import util.BookT;
import util.Member;
import util.MemberTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface MemberBO extends SuperBO {

    public List<Member> CountPercentageMemberCategoryWise() throws Exception;

    public List<Member> getfewMemberDetails() throws Exception;

    public boolean updateCategory(String id,String valueid, Date expdate) throws Exception;

    Member getSingleMemberByAll(MemberSearchType memberSearchType, String value) throws Exception;

    public String getNewMemberID() throws Exception;

    public List<MemberTM> getAllMembers() throws Exception;

    public MemberTM getSingleMember(String memberID)throws Exception;

    public boolean saveMember(String memberID, String memberNIC, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExpDate)throws Exception;

    public boolean deleteMember(String memberID)throws Exception;

    public boolean updateMember(String memberNIC,String mName, String mType,String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExoDate,String memberID)throws Exception;

    public boolean updateMemberWithoutAddDate(String memberNIC,String mName, String mType,String mAddress, String mEmail, String gender, String mPhoneNo, Date mExoDate,String memberID)throws Exception;

}
