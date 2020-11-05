package dao.custom;

import Entity.Issue_Book;
import Entity.Issue_DetailPK;
import Entity.Member;
import dao.CrudDAO;

import java.sql.Date;

public interface Issue_BookDAO extends CrudDAO<Issue_Book, Issue_DetailPK> {
    public boolean updateDate(String bookID, Date date) throws Exception;
    public String getLastIssueID() throws Exception;
}
