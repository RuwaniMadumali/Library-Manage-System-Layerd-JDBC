package bussiness.custom.impl;

import Entity.Book;
import bussiness.BookSearchType;
import bussiness.custom.BookBO;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import dao.DAOFActory;
import dao.DAOType;
import dao.custom.BookDAO;
import util.BookT;
import util.BookTM;
import util.Issue_BookTM;
import util.ReturnsTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookBOImpl implements BookBO {
    private BookDAO bookDAO = DAOFActory.getInstance().getDAO(DAOType.BOOK);

    @Override
    public List<BookT> getBookListByBookListIDs(List<Issue_BookTM> issue_bookIds) throws Exception {
        List<BookT> reissueBookList=new ArrayList<>();
        Iterator<Issue_BookTM> iterator = issue_bookIds.iterator();
        while (iterator.hasNext()){
            Issue_BookTM singleBookId=iterator.next();
            Book singlrbook=bookDAO.find(singleBookId.getBookID());
            BookT book = new BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
            reissueBookList.add(book);
        }
        return reissueBookList;
    }

    @Override
    public BookT getSingleBookByAll(BookSearchType bookSearchType, String value) throws Exception {

        Book singlrbook;

        switch (bookSearchType){
            case BOOK_ID:{
                singlrbook=bookDAO.find(value);
                return new BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
            }
            case BOOK_TITLE:{singlrbook=bookDAO.findByBookTitle(value);
                return new BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
            }
            case BOOK_AUTHOR:{singlrbook=bookDAO.findByAuthor(value);
                return new BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
            }
            case BOOK_CATEGORY:{singlrbook=bookDAO.findByCategory(value);
                return new  BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
            }
            default:{
                return  null;
            }
        }
    }

    @Override
    public List<BookT> findfewAll() throws Exception {
        List<Book> allBooks = bookDAO.findAll();
        List<BookT> books = new ArrayList<>();
        for (Book book : allBooks) {
            books.add(new BookT(book.getBookID(),book.getbCategoryID(),book.getbName(),book.getbAuthor(),book.getbEdition(),book.getbPrice().doubleValue(),book.getbNoOfPages(),book.getbDescription()));
        }
        return books;
    }

    @Override
    public String getNewBookID() throws Exception {
        String lastBookID = bookDAO.getLastBookID();

        if (lastBookID == null) {
            return "B001";
        } else {
            int maxId = Integer.parseInt(lastBookID.replace("B", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "B00" + maxId;
            } else if (maxId < 100) {
                id = "B0" + maxId;
            } else {
                id = "B" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<BookTM> getAllBooks() throws Exception {
        List<Book> allBooks = bookDAO.findAll();
        List<BookTM> books = new ArrayList<>();
        for (Book book : allBooks) {
            books.add(new BookTM(book.getBookID(),book.getbCategoryID(),book.getbName(),book.getbDescription(),book.getbEdition(),book.getbAuthor(),book.getbNoOfPages(),book.getbPrice().doubleValue(),book.getPathToImage(),book.getbAddDate()));
        }
        return books;
    }

    @Override
    public BookT getSingleBook(String bookID) throws Exception {
        Book singlrbook=bookDAO.find(bookID);
        BookT book = new BookT(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbAuthor(),singlrbook.getbEdition(),singlrbook.getbPrice().doubleValue(),singlrbook.getbNoOfPages(),singlrbook.getbDescription());
        return book;
    }

    @Override
    public boolean saveBook(String bookID, String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate) throws Exception {
        return bookDAO.save(new Book(bookID,bCategoryID,bName,bDescription,bEdition,bAuthor,bNoOfPages,BigDecimal.valueOf(bPrice),pathToImage,bAddDate));
    }

    @Override
    public boolean deleteBook(String bookID) throws Exception {
        return bookDAO.delete(bookID);
    }

    @Override
    public boolean updateBook(String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, double bPrice, String pathToImage, Date bAddDate, String bookID) throws Exception {
        return bookDAO.update(new Book(bookID,bCategoryID,bName,bDescription,bEdition,bAuthor,bNoOfPages,BigDecimal.valueOf(bPrice),pathToImage,bAddDate));
    }
}
