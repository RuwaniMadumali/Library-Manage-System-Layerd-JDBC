package bussiness;

import bussiness.custom.impl.*;


public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory==null) ? boFactory = new BOFactory() : boFactory ;
    }
    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case BOOK:
                return (T) new BookBOImpl();
            case BOOK_CATEGORY:
                return (T) new Book_CategoryBOImpl();
            case DELAY_PAYMENT:
                return (T) new Book_CategoryBOImpl();
            case ISSUE_BOOK:
                return (T) new Issue_BookBOImpl();
            case MEMBER_TYPE:
                return (T) new Member_TypeBOImpl();
            case MEMBER:
                return (T) new MemberBOImpl();
            case RECEIPT:
                return (T) new ReceiptBOImpl();
            case RENEWAL_PAYMENT:
                return (T) new Renewal_PaymentBOImpl();
            case RETURNS:
                return (T) new ReturnsBOImpl();
            case STAFF:
                return (T) new StaffBOImpl();
            default:
                return null;
        }
    }
}
