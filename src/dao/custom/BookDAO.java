package dao.custom;


import Entity.Book;
import dao.CrudDAO;

import java.util.List;

public interface BookDAO extends CrudDAO<Book,String> {

    String getLastBookID() throws Exception;

    Book findByBookTitle(String value) throws Exception;
    Book findByAuthor(String value) throws Exception;
    Book findByCategory(String value) throws Exception;

    List<Book> findfewAll() throws Exception;

}
