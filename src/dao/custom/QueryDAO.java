package dao.custom;

import Entity.CustomEntity;
import dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    CustomEntity getToReturnBooksByBookID(String bookId) throws Exception;

    List<CustomEntity> getToReturnBooksByMemberID(String memberId) throws Exception;



}
