package dao.custom.impl;

import Entity.Receipt;
import dao.CrudUtil;
import dao.custom.ReceiptDAO;

import java.util.List;

public class ReceiptDAOImpl implements ReceiptDAO {
    @Override
    public List<Receipt> findAll() throws Exception {
        return null;
    }

    @Override
    public Receipt find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Receipt receipt) throws Exception {
        return CrudUtil.execute("INSERT INTO Receipt VALUES (?,?,?,?,?)",receipt.getReciptNo(),
                receipt.getReason(),receipt.getIssuedDate(),receipt.getIssuedStaffID(),receipt.getPaymentmood());
    }

    @Override
    public boolean update(Receipt entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
