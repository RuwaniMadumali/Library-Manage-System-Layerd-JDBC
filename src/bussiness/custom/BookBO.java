package bussiness.custom;

import Entity.Book;
import bussiness.BookSearchType;
import bussiness.SuperBO;
import util.BookT;
import util.BookTM;
import util.Issue_BookTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookBO extends SuperBO {
    public List<BookT> getBookListByBookListIDs(List<Issue_BookTM> issue_bookIds)throws Exception;

    public BookT getSingleBookByAll(BookSearchType bookSearchType,String value) throws Exception;

    public List<BookT> findfewAll() throws Exception;

    public String getNewBookID() throws Exception;

    public List<BookTM> getAllBooks() throws Exception;

    public BookT getSingleBook(String bCategoryID)throws Exception;

    public boolean saveBook(String bookID, String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate)throws Exception;

    public boolean deleteBook(String bookID)throws Exception;

    public boolean updateBook(String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate, String bookID)throws Exception;

}
