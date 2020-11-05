package dao.custom.impl;

import Entity.Dalay_Payment;
import Entity.Delay_PaymentPK;
import Entity.Issue_Book;
import dao.CrudUtil;
import dao.custom.Delay_PaymentDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Delay_PaymentDAOImpl implements Delay_PaymentDAO {
    @Override
    public List<Dalay_Payment> findAll() throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Delay_Payment ");
        List<Dalay_Payment> dalay_payments= new ArrayList<>();
        while (rst.next()){
            dalay_payments.add(new Dalay_Payment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getBigDecimal(5)
                   ));
        }
        return  dalay_payments;
    }

    @Override
    public Dalay_Payment find(Delay_PaymentPK key) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Delay_Payment WHERE issueNo=? AND bookID=?",key);
        while (rst.next()){
            return new Dalay_Payment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getBigDecimal(5));

        }
        return null;
    }

    @Override
    public boolean save(Dalay_Payment entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Delay_Payments VALUES (?,?,?,?,?)",
                entity.getIssueNo(),entity.getBookID(),entity.getMemberID(),entity.getLateDates(),entity.getAppliedCharges());
    }

    @Override
    public boolean update(Dalay_Payment entity) throws Exception {
        return CrudUtil.execute("UPDATE Delay_Payments SET memberID=? ,lateDays=?,appliedCharges=? WHERE issuID=? AND bookID=? ",entity.getMemberID(),entity.getLateDates());
    }

    @Override
    public boolean delete(Delay_PaymentPK key) throws Exception {
        return CrudUtil.execute("DELETE FROM Delay_Payment WHERE issueNo=? AND bookID=?",key);
    }

}
