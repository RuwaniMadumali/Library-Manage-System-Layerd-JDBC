package bussiness.custom;

import bussiness.SuperBO;
import util.CustomTM;

import java.sql.Date;
import java.util.List;

public interface ReturnsBO extends SuperBO {

    public List<CustomTM> getToReturnBooksByBookID(String bookID)throws Exception;

    public List<CustomTM> getToReturnBooksByMemberID(String memberID)throws Exception;

    public List<CustomTM> getToReturnDetails(String id)throws Exception;

    public double calDalaypayments (double charges, Date returnDate)throws Exception;
}
