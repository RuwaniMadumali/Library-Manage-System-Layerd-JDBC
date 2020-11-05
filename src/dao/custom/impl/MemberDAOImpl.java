package dao.custom.impl;

import Entity.Book;
import Entity.Member;
import dao.CrudUtil;
import dao.custom.MemberDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public List<Member> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Member");
        List<Member> members = new ArrayList<>();
        while (rst.next()) {
            members.add(new Member(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDate(9),
                    rst.getDate(10)));
        }
        return members;
    }

    @Override
    public Member find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT memberID,memberNIC,mName,mAddress,mEmail,gender,mPhoneNo,mType,mExpDate FROM Member WHERE memberID=?", key);
        if (rst.next()) {
            return new Member(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDate(9)
            );
        }
        return null;
    }
    @Override
    public Member findByMemberNIC(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT memberID,memberNIC,mName,mAddress,mEmail,gender,mPhoneNo,mType,mExpDate FROM Member WHERE memberNIC=?", key);
        if (rst.next()) {
            return new Member(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDate(9)
            );
        }
        return null;
    }

    @Override
    public Member findByMemberName(String value) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT memberID,memberNIC,mName,mAddress,mEmail,gender,mPhoneNo,mType,mExpDate FROM Member WHERE mName=?", value);
        if (rst.next()) {
            return new Member(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDate(9)
            );
        }
        return null;
    }

    @Override
    public boolean updateMembership(String id, String value, Date date) throws Exception {
        return CrudUtil.execute("UPDATE Member SET mType=?,mExpDate=? WHERE memberID=?",value,date,id);
    }

    @Override
    public boolean updateMember(Member member) throws Exception {
        return CrudUtil.execute("UPDATE Member SET mName=?, mType=?, mAddress=?, mEmail=?, gender=?,mPhoneNo=?, mExpDate=? WHERE memberID=?",
                member.getmName(),member.getmType(),member.getmAddress(),member.getmEmail(),member.getGender(),member.getmPhoneNo(),member.getmExpDate(),member.getMemberID() );

    }

    @Override
    public boolean save(Member member) throws Exception {
        return CrudUtil.execute("INSERT INTO Member VALUES (?,?,?,?,?,?,?,?,?,?)",
                member.getMemberID(),member.getmName(),member.getmType(),member.getmAddress(),
                member.getmEmail(),member.getGender(),member.getmPhoneNo(),member.getmAddDate(),member.getmExpDate(),member.getMemberNIC());
    }

    @Override
    public boolean update(Member member) throws Exception {
        return CrudUtil.execute("UPDATE Member SET mName=?, mType=?, mAddress=?, mEmail=?, gender=?,mPhoneNo=?, mAddDate=?, mExpDate=? WHERE memberID=?",member.getmName(),member.getmType(),member.getmAddress(),member.getmEmail(),member.getGender(),member.getmPhoneNo(),member.getmAddDate(),member.getmExpDate(),member.getMemberID() );

    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Member WHERE memberID=?",key);
    }

    @Override
    public String getLastMemberID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Member ORDER BY memberID DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public List<Member> findfewAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT memberID,memberNIC,mName,mAddress,mEmail,gender,mPhoneNo,mType,mExpDate FROM Member");
        List<Member> members = new ArrayList<>();
        while (rst.next()) {
            members.add(new Member(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDate(9)));
        }
        return members;
    }

    @Override
    public List<Member> getCountMemberCategoryWise() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT mType, COUNT(*) FROM member GROUP BY mType;");
        List<Member> members = new ArrayList<>();
        while (rst.next()) {
            members.add(new Member(rst.getString(1),
                    rst.getInt(2)
            ));
        }
        return members;
    }
}
