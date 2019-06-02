package cn.mcandoird.mapper;

import cn.mcandoird.pojo.Bill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillMapper {
    Bill getMax();

    Bill getBillById(int id);

    List<Bill> getAll();

    List<Bill> getBillByDate(Date date);


    List<Bill> getPage(Map<String, Integer> map);

    int getCount();

    /**
     * 根据id删除账单
     *
     * @param id
     * @return
     */
    int delBillById(int id);


    /**
     * 修改账单
     * @param bill
     * @return
     */
    int updateBill(Bill bill);



    double sum(Date date) ;

    /**
     * 获取库中的存在的月份
     * @return
     */
    String [] findAllMonth();


    /**
     * 获得指定月份的指定支付方式的 次数
     * 例如：
     *  map.put("date",new Date());
     *  map.put("pay_mode","微信");
     * @param map
     * @return 次数
     */
    int getCountByPay_modeAndDate(Map<String,Object>map);

    /**
     * 获取当前月份所有的支付方式
     * @return
     */
    String []getAllPay_mode(Date date);

    /**
     * 通过支付方式和日期获取消费金额
     * 例如：
     * map.put("date",new Date());
     * map.put("pay_mode","微信");
     * @param map
     * @return
     */
    double getSumByPay_modeAndDate(Map<String,Object>map);


}


