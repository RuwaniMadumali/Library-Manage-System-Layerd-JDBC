package dao.custom.impl;

import Entity.Member;
import dao.custom.MemberDAO;

import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public List<Member> findAll() throws Exception {
        return null;
    }

    @Override
    public Member find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Member entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Member entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
