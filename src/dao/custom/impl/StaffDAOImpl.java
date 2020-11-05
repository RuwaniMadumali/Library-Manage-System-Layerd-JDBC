package dao.custom.impl;

import Entity.Staff;
import dao.CrudUtil;
import dao.custom.StaffDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public List<Staff> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Staff");
        List<Staff> staff = new ArrayList<>();
        while (rst.next()) {
            staff.add(new Staff(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }
        return staff;
    }

    @Override
    public Staff find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Staff WHERE staffID=?", key);
        if (rst.next()) {
            return new Staff(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5));
        }
        return null;
    }

    @Override
    public boolean save(Staff staff) throws Exception {
        return CrudUtil.execute("INSERT INTO Staff VALUES (?,?,?,?,?)",
                staff.getStaffID(),
                staff.getsName(),
                staff.getsPosition(),
                staff.getUserName(),
                staff.getPassWord() );
    }

    @Override
    public boolean update(Staff staff) throws Exception {
        return CrudUtil.execute("UPDATE Staff SET sName=?, sPosition=?, userName=?, password=? WHERE staffID=?",
                staff.getsName(),
                staff.getsPosition(),
                staff.getUserName(),
                staff.getPassWord(),
                staff.getStaffID());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Staff WHERE staffID=?",key);
    }
}
