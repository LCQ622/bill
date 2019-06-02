package cn.mcandoird.service.impl;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.page.Page;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.PageService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PageServiceImpl implements PageService {

    @Override
    public Page showPage(int start, int size) throws IOException {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
        SqlSession session = factory.openSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        Page<Bill> page = new Page<>();
        page.setPageNum(start);
        page.setPageSize(size);
        Map<String, Integer> map = new HashMap<>();
        map.put("start", page.getPageSize() * (page.getPageNum() - 1));
        map.put("size", page.getPageSize());
        page.setList(mapper.getPage(map));
        page.setTotal(mapper.getCount() % page.getPageSize() == 0 ? mapper.getCount() / page.getPageSize() : mapper.getCount() / page.getPageSize() + 1);
        session.close();
        return page;
    }
}
