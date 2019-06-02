package cn.mcandoird.service;

import cn.mcandoird.pojo.Bill;

import java.io.IOException;

public interface AddBillService {
    public boolean addBill(Bill bill) throws IOException;
}
