package cn.mcandoird.service;

import java.io.IOException;

public interface DelService {
    /**
     * 通id 删除 一条记录
     * @param id
     * @return
     * @throws IOException
     */
    public boolean delBillById(int id) throws IOException;
}
