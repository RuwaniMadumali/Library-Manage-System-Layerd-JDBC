package bussiness.custom.impl;

import bussiness.custom.StaffBO;
import util.StaffTM;

import java.sql.Date;
import java.util.List;

public class StaffBOImpl implements StaffBO {
    @Override
    public List<StaffTM> getAllstaff() throws Exception {
        return null;
    }

    @Override
    public boolean saveMember(String memberID, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExoDate) throws Exception {
        return false;
    }

    @Override
    public boolean deleteMember(String memberID) throws Exception {
        return false;
    }

    @Override
    public boolean updateMember(String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExoDate, String memberID) throws Exception {
        return false;
    }
}
