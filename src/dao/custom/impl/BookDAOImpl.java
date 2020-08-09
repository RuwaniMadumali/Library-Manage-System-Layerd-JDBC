package dao.custom.impl;

import Entity.Book;
import dao.CrudUtil;
import dao.custom.BookDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Book");
        List<Book> books = new ArrayList<>();
        while (rst.next()) {
            books.add(new Book(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getBigDecimal(8),
                    rst.getString(9),
                    rst.getDate(10)));
        }
        return books;
    }

    @Override
    public Book find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Book WHERE bookID=?", key);
        if (rst.next()) {
            return new Book(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getBigDecimal(8),
                    rst.getString(9),
                    rst.getDate(10));
        }
        return null;
    }

    @Override
    public boolean save(Book book) throws Exception {
        return CrudUtil.execute("INSERT INTO Book VALUES (?,?,?,?,?,?,?,?,?,?)",
                book.getBookID(),book.getbCategoryID(),book.getbName(),book.getbDescription(),book.getbEdition(),book.getbAuthor(),book.getbNoOfPages(),book.getbPrice(),book.getPathToImage(),book.getbAddDate());
    }

    @Override
    public boolean update(Book book) throws Exception {
        return CrudUtil.execute("UPDATE Book SET bCategoryID=?, bNAme=?, bDescription=?, bEdition=?, bAuthor=?,bNoOfPages=?, bPrice=?, pathToImage=?, bAddDate=? WHERE bookID=?", book.getbCategoryID(),book.getbName(), book.getbDescription(),book.getbEdition(),book.getbAuthor(),book.getbNoOfPages(), book.getbPrice(), book.getPathToImage(), book.getbAddDate(),book.getbAddDate());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE * FROM Book WHERE bookID=?",key);
    }


    @Override
    public String getLastBookID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Book ORDER BY bookID DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }

    }
}
