package cn.mcandoird.service.impl;

import cn.mcandoird.Util.Util;
import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.service.ChartService;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class ChartServiceImpl implements ChartService {
    /**
     * 获取月份消费总额
     *
     * @param date
     * @return
     */
    @Override
    public Map<String, Object> sum(Date date) {
        Map<String, Object> map = new HashMap<>();


        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        double sum = mapper.sum(date);

        map.put("date", Util.getStrByDate(date, "yyyy-MM"));
        map.put("sum", sum);

        session.close();
        return map;
    }


    /**
     * 获取所有月份消费总额的json数据
     *
     * @return
     */
    public String getJson() {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        Gson gson = new Gson();
        List<Map<String, Object>> list = new ArrayList<>();
        String months[] = mapper.findAllMonth();
        for (String s : months) {
            Map<String, Object> m1 = sum(Util.getDatebyStr(s, "yyyy-MM"));
            list.add(m1);
        }
        session.close();
        return gson.toJson(list);
    }


    public double getSumByPay_modeAndDate(Date date, String pay_mode) {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("pay_mode", pay_mode);

        double money = mapper.getSumByPay_modeAndDate(map);
        session.close();
        return money;
    }


    /**
     * 通过日期获取每种支付方式的总金额
     *
     * @param date
     */
    public List<Map<String, Object>> getSumByDate(Date date) {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        List<Map<String, Object>> list = new ArrayList<>();

        String[] strs = mapper.getAllPay_mode(date);
        for (String s : strs) {
            Map<String, Object> map = new HashMap<>();
            map.put("pay_mode", s);
            map.put("sum", getSumByPay_modeAndDate(date, s));
            list.add(map);
        }
        session.close();
        return list;
    }

    public List<Map<String, Object>> getCountByDate(Date date) {
        SqlSession session = Util.getSqlSession();
        BillMapper mapper = session.getMapper(BillMapper.class);
        List<Map<String, Object>> list = new ArrayList<>();
        String[] strs = mapper.getAllPay_mode(date);
        for (String s : strs) {
            Map<String, Object> m1 = new HashMap<>();
            m1.put("date",date);
            m1.put("pay_mode", s);
            Map<String, Object>map=new HashMap<>();
            map.put("pay_mode",s);
            map.put("count", mapper.getCountByPay_modeAndDate(m1));
            list.add(map);
        }
        session.close();
        return list;

    }


}
