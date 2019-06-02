package cn.mcandoird.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    /**
     * 该方法用于获取 SqlSession
     * @return
     */
    public   static SqlSession getSqlSession(){
        SqlSessionFactory factory= null;
        try {
            factory = new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession session=factory.openSession();
        return session;
    }


    /**
     * 该方法用于关闭SqlSession
     * @param session
     */
    public static  void clossSqlsession(SqlSession session){
        if (session!=null){
            session.close();
        }
    }


    /**
     * 该方法用于将字符串的日期转换成Date
     * @param str
     * @param format
     * @return
     */
    public static Date  getDatebyStr(String str,String format){
        SimpleDateFormat f=new SimpleDateFormat(format);
        Date date= null;
        try {
            date = f.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    /**
     * 该方法用于将Date转换成String
     * @param date
     * @param format 格式
     * @return 字符串
     */
    public  static  String getStrByDate(Date date ,String format){
        SimpleDateFormat f=new SimpleDateFormat(format);
       return f.format(date);
    }

}
