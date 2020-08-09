package bussiness.custom.impl;

import Entity.Book;
import bussiness.custom.BookBO;
import dao.DAOFActory;
import dao.DAOType;
import dao.custom.BookDAO;
import util.BookTM;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    private BookDAO bookDAO = DAOFActory.getInstance().getDAO(DAOType.BOOK);


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
    public BookTM getSingleBook(String bookID) throws Exception {
        Book singlrbook=bookDAO.find(bookID);
        BookTM book = new BookTM(singlrbook.getBookID(),singlrbook.getbCategoryID(),singlrbook.getbName(),singlrbook.getbDescription(),singlrbook.getbEdition(),singlrbook.getbAuthor(),singlrbook.getbNoOfPages(),singlrbook.getbPrice().doubleValue(),singlrbook.getPathToImage(),singlrbook.getbAddDate());
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
