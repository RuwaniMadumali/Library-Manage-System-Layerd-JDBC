package util;

public class Book_CategoryTM {
    private String categoryID;
    private String category;

    public Book_CategoryTM() {
    }

    public Book_CategoryTM(String categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book_CategoryTM{" +
                "categoryID='" + categoryID + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
