package dao.custom;

import Entity.Returns;
import Entity.ReturnsPK;
import dao.CrudDAO;

public interface ReturnsDAO extends CrudDAO<Returns, ReturnsPK> {

    public boolean deleteRecord(String issueNo,String bookID) throws  Exception;
}
