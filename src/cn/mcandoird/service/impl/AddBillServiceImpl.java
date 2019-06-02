package cn.mcandoird.service.impl;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.AddBillService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class AddBillServiceImpl implements AddBillService {

    @Override
    public boolean addBill(Bill bill) throws IOException {
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
        SqlSession session=factory.openSession();
        int count =session.insert("cn.mcandoird.mapper.BillMapper.addBill",bill);
        session.commit();
        session.close();
        if(count>=0){
            return true;
        }

        return false;
    }
}
