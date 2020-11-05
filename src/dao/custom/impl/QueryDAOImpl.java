package dao.custom.impl;

import Entity.CustomEntity;
import Entity.Member;
import dao.CrudUtil;
import dao.custom.QueryDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public CustomEntity getToReturnBooksByBookID(String bookId) throws Exception {

        System.out.println("execute DAO -->"+bookId);
        ResultSet rst= CrudUtil.execute(
                "SELECT i.memberID,m.mName,m.mType,mt.charges,i.issueNo,i.bookID,b.bName,i.returnDate " +
                        "FROM issue_book i " +
                        "INNER JOIN book b on i.bookID = b.bookID " +
                        "INNER JOIN member m on i.memberID = m.memberID " +
                        "INNER JOIN member_type mt on m.mType = mt.typeID " +
                        "WHERE i.bookID=?",bookId);
        if (rst.next()){
            System.out.println("results in DAO");
            return new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getDate(8)
            );
        }
      return null;
    }

    @Override
    public List<CustomEntity> getToReturnBooksByMemberID(String memberId) throws Exception {
        ResultSet rst= CrudUtil.execute(
                "SELECT i.memberID,m.mName,m.mType,mt.charges,i.issueNo,i.bookID,b.bName,i.returnDate " +
                        "FROM issue_book i " +
                        "INNER JOIN book b on i.bookID = b.bookID " +
                        "INNER JOIN member m on i.memberID = m.memberID " +
                        "INNER JOIN member_type mt on m.mType = mt.typeID " +
                        "WHERE i.memberID=?",memberId);
        List<CustomEntity> customEntities= new ArrayList<>();

        while (rst.next()){
            customEntities.add(new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getDate(8)
            ));

        }
        return customEntities;
    }
}
