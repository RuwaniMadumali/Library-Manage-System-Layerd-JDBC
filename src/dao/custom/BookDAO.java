package dao.custom;


import Entity.Book;
import dao.CrudDAO;

public interface BookDAO extends CrudDAO<Book,String> {

    String getLastBookID() throws Exception;
}
