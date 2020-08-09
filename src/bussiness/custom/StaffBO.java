package bussiness.custom;

;

import util.StaffTM;

import java.sql.Date;
import java.util.List;

public interface StaffBO {
    public List<StaffTM> getAllstaff() throws Exception;

    public boolean saveMember(String memberID, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExoDate)throws Exception;

    public boolean deleteMember(String memberID)throws Exception;

    public boolean updateMember(String mName, String mType,String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExoDate,String memberID)throws Exception;

}
