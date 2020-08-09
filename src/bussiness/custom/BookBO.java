package bussiness.custom;

import bussiness.SuperBO;
import util.BookTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookBO extends SuperBO {

    public String getNewBookID() throws Exception;

    public List<BookTM> getAllBooks() throws Exception;

    public BookTM getSingleBook(String bCategoryID)throws Exception;

    public boolean saveBook(String bookID, String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate)throws Exception;

    public boolean deleteBook(String bookID)throws Exception;

    public boolean updateBook(String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate, String bookID)throws Exception;

}
