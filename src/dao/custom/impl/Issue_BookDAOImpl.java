package dao.custom.impl;

import Entity.Issue_Book;
import Entity.Issue_DetailPK;
import dao.CrudUtil;
import dao.custom.Issue_BookDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Issue_BookDAOImpl implements Issue_BookDAO {
    @Override
    public List<Issue_Book> findAll() throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Issue_Book ");
        List<Issue_Book> issue_books= new ArrayList<>();
        while (rst.next()){
            issue_books.add(new Issue_Book(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getDate(5),rst.getString(6)));
        }
        return  issue_books;
    }

    @Override
    public Issue_Book find(Issue_DetailPK key) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Issue_Book WHERE issueNo=? AND bookID=?",key);
        while (rst.next()){
            return new Issue_Book(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getString(6));

        }
        return null;
    }

    @Override
    public boolean save(Issue_Book entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Issue_book VALUES(?,?,?,?,?,?)",
                entity.getIssueNo(),
                entity.getBookID(),
                entity.getMemberID(),
                entity.getIssueDate(),
                entity.getReturnDate(),
                entity.getIssueStaffID());
    }

    @Override
    public boolean update(Issue_Book entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Issue_DetailPK key) throws Exception {
        return false;
    }

    @Override
    public boolean updateDate(String bookID, Date date) throws Exception {
        return CrudUtil.execute("UPDATE Issue_book SET returnDate=? WHERE issueNo=?",date,bookID);
    }

    @Override
    public String getLastIssueID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Issue_book ORDER BY issueNo DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }

    }
}
