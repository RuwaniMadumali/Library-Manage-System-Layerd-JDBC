package dao.custom;

import Entity.Book;
import Entity.Member;
import dao.CrudDAO;

import java.sql.Date;
import java.util.List;

public interface
MemberDAO extends CrudDAO<Member,String> {

    String getLastMemberID() throws Exception;
    Member findByMemberNIC(String value) throws Exception;
    Member findByMemberName(String value) throws Exception;
    boolean updateMembership(String id, String value, Date date) throws Exception;
    boolean updateMember(Member member) throws Exception;
    List<Member> findfewAll() throws Exception;
    List<Member> getCountMemberCategoryWise()throws Exception;
}
