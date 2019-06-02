package cn.mcandoird.service;

import cn.mcandoird.pojo.Bill;

import java.io.IOException;

public interface EditService {
    /**
     * 通过 id 查找账单
     * @param id
     * @return
     */
    Bill getBillById(int id) throws IOException;

    /**
     * 修改一条记录
     * @return
     */
    boolean updateBill(Bill bill) throws IOException;
}
