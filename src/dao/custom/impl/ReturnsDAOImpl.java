package dao.custom.impl;


import Entity.Returns;
import Entity.ReturnsPK;
import dao.CrudUtil;
import dao.custom.ReturnsDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReturnsDAOImpl implements ReturnsDAO {
    @Override
    public List<Returns> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Returns");
        List<Returns> returns = new ArrayList<>();
        while (rst.next()) {
            returns.add(new Returns(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getDate(4),
                    rst.getString(5)));
        }
        return returns;
    }

    @Override
    public Returns find(ReturnsPK key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Returns WHERE issueNo=? AND bookID=?",key);
        while (rst.next()){
            return new Returns(rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getDate(4),
                    rst.getString(5));

        }
        return null;

    }

    @Override
    public boolean save(Returns ret) throws Exception {
        return CrudUtil.execute("INSERT INTO Returns VALUES (?,?,?,?,?)",
                ret.getIssueNo(),ret.getBookID(),ret.getReturnDate(),ret.getActualReturnDate(),ret.getIssueStaffID());
    }

    @Override
    public boolean update(Returns entity) throws Exception {
        return CrudUtil.execute("UPDATE Returns SET returnDAte=?, actualReturnDate=?,issueStaddID=? WHERE issueNo=? AND bookID=?",entity.getReturnDate(),entity.getActualReturnDate(),entity.getIssueStaffID(),entity.getIssueNo(),entity.getBookID());
    }

    @Override
    public boolean delete(ReturnsPK key) throws Exception {
        return CrudUtil.execute("DELETE FROM Returns WHERE issueNo=? AND bookID=?",key);
    }

    @Override
    public boolean deleteRecord(String issueNo, String bookID) throws Exception {
        return CrudUtil.execute("DELETE FROM issue_book WHERE issueNo=? AND bookID=?",issueNo,bookID);
    }
}
