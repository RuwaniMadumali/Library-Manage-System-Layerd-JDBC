package dao;


import dao.custom.impl.*;

public class DAOFActory {

    private static DAOFActory daofActory;

    public DAOFActory() {
    }

    public static DAOFActory getInstance(){
        return (daofActory==null)? daofActory = new DAOFActory():daofActory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case BOOK:
                return (T) new BookDAOImpl();
            case BOOK_CATEGORY:
                return (T) new Book_CategoryDAOImpl();
            case DELAY_PAYMENT:
                return (T) new Book_CategoryDAOImpl();
            case ISSUE_BOOK:
                return (T) new Issue_BookDAOImpl();
            case MEMBER_TYPE:
                return (T) new Member_TypeDAOImpl();
            case MEMBER:
                return (T) new MemberDAOImpl();
            case RECEIPT:
                return (T) new ReceiptDAOImpl();
            case RENEWAL_PAYMENT:
                return (T) new Renewal_PaymentDAOImpl();
            case RETURNS:
                return (T) new ReturnsDAOImpl();
            case STAFF:
                return (T) new StaffDAOImpl();
            default:
                return null;
        }
    }
}
