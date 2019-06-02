package cn.mcandoird.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ChartService {
    Map<String ,Object>  sum(Date date);
    String getJson();

    double getSumByPay_modeAndDate(Date date,String pay_mode);
    List< Map<String,Object>> getSumByDate(Date date);

    List<Map<String, Object>> getCountByDate(Date date);
}
