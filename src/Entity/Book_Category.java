package Entity;

public class Book_Category implements SuperEntity {
    private String categoryID;
    private String category;

    public Book_Category() {
    }

    public Book_Category(String categoryID, String category) {
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
        return "Book_Category{" +
                "categoryID='" + categoryID + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
