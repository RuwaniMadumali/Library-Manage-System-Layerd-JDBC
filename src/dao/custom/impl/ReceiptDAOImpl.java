package dao.custom.impl;

import Entity.Receipt;
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
    public boolean save(Receipt entity) throws Exception {
        return false;
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
