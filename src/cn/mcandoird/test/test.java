package cn.mcandoird.test;

import cn.mcandoird.Util.Util;
import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.ChartService;
import cn.mcandoird.service.impl.ChartServiceImpl;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.*;

public class test {
    ChartService service = new ChartServiceImpl();

    @Test
    public void t1() {


        ChartService service = new ChartServiceImpl();
        Map<String, Object> m1 = service.sum(Util.getDatebyStr("2018-11", "yyyy-MM"));
        Map<String, Object> m2 = service.sum(Util.getDatebyStr("2018-12", "yyyy-MM"));
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);

        Gson gson = new Gson();

        System.out.println(gson.toJson(list));


    }

    @Test
    public void t2() {
        ChartService service = new ChartServiceImpl();
        System.out.println(service.getJson());
    }

    @Test
    public void t3() {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("date", new Date());
        map.put("pay_mode", "Î¢ÐÅ");
        int a = mapper.getCountByPay_modeAndDate(map);
        System.out.println(a);

        session.close();

    }

    @Test
    public void t4() {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);

        String[] strs = mapper.getAllPay_mode(new Date());
        for (String s : strs) {
            System.out.println(s);
        }

        session.close();

    }

    @Test
    public void t5() {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("date", Util.getDatebyStr("2018-11", "yyyy-MM"));
        map.put("pay_mode", "Ö§¸¶±¦");
        double sum = mapper.getSumByPay_modeAndDate(map);
        System.out.println(sum);
        session.close();
    }

    @Test
    public void t6() {

    }
}
