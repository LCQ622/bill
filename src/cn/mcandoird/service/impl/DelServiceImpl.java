package cn.mcandoird.service.impl;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.service.DelService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class DelServiceImpl implements DelService {
    @Override
    public boolean delBillById(int id) throws IOException {
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
        SqlSession session=factory.openSession();
        BillMapper mapper=session.getMapper(BillMapper.class);

        int count=mapper.delBillById(id);
        session.commit();
        session.close();
        if (count>0){
            return true;
        }
        return false;
    }
}
