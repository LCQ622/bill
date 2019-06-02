package cn.mcandoird.service.impl;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.EditService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class EditServiceImpl implements EditService {
    @Override
    public Bill getBillById(int id) throws IOException {
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
        SqlSession session=factory.openSession();
        BillMapper mapper=session.getMapper(BillMapper.class);
        Bill bill=mapper.getBillById(id);
        session.commit();
        session.close();
        return bill;
    }

    @Override
    public boolean updateBill(Bill bill) throws IOException {
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
        SqlSession session=factory.openSession();
        BillMapper mapper=session.getMapper(BillMapper.class);
        int count=mapper.updateBill(bill);
        session.commit();
        session.close();
        if(count>0){
            return true;
        }

        return false;
    }
}
