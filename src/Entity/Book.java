package Entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Book implements SuperEntity {
   private String bookID ;
   private String bCategoryID ;
   private String bName ;
   private String bDescription ;
   private String bEdition ;
   private String bAuthor ;
   private int bNoOfPages ;
   private BigDecimal bPrice ;
   private String pathToImage ;
   private Date bAddDate ;

    public Book() {
    }

    public Book(String bookID, String bCategoryID, String bName, String bAuthor, String bEdition, BigDecimal bPrice,  int bNoOfPages,String bDescription) {
        this.bookID = bookID;
        this.bCategoryID = bCategoryID;
        this.bName = bName;
        this.bDescription = bDescription;
        this.bEdition = bEdition;
        this.bAuthor = bAuthor;
        this.bNoOfPages = bNoOfPages;
        this.bPrice = bPrice;
    }

    public Book(String bookID, String bCategoryID, String bName, String bDescription, String bEdition, String bAuthor, int bNoOfPages, BigDecimal bPrice, String pathToImage, Date bAddDate) {
        this.bookID = bookID;
        this.bCategoryID = bCategoryID;
        this.bName = bName;
        this.bDescription = bDescription;
        this.bEdition = bEdition;
        this.bAuthor = bAuthor;
        this.bNoOfPages = bNoOfPages;
        this.bPrice = bPrice;
        this.pathToImage = pathToImage;
        this.bAddDate = bAddDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getbCategoryID() {
        return bCategoryID;
    }

    public void setbCategoryID(String bCategoryID) {
        this.bCategoryID = bCategoryID;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbDescription() {
        return bDescription;
    }

    public void setbDescription(String bDescription) {
        this.bDescription = bDescription;
    }

    public String getbEdition() {
        return bEdition;
    }

    public void setbEdition(String bEdition) {
        this.bEdition = bEdition;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public int getbNoOfPages() {
        return bNoOfPages;
    }

    public void setbNoOfPages(int bNoOfPages) {
        this.bNoOfPages = bNoOfPages;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public Date getbAddDate() {
        return bAddDate;
    }

    public void setbAddDate(Date bAddDate) {
        this.bAddDate = bAddDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", bCategoryID='" + bCategoryID + '\'' +
                ", bName='" + bName + '\'' +
                ", bDescription='" + bDescription + '\'' +
                ", bEdition='" + bEdition + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bNoOfPages=" + bNoOfPages +
                ", bPrice=" + bPrice +
                ", pathToImage='" + pathToImage + '\'' +
                ", bAddDate=" + bAddDate +
                '}';
    }
}
