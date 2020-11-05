package bussiness.custom;



import bussiness.SuperBO;
import util.Delay_PaymentTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface Delay_PaymentBO extends SuperBO {
    public List<Delay_PaymentTM> getAllBooks() throws Exception;

    public boolean saveDelayPayments(String issueNo, String bookID, String memberID,int lateDays, BigDecimal appliedCharges)throws Exception;

    // public boolean deleteDelayPayments(String issueNo,String bookID)throws Exception;

    //public boolean updateDelayPayments(String memberID,int lateDays, BigDecimal appliedCharges,String issueNo, String bookID)throws Exception;

}
