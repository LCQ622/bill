package cn.mcandoird.servlet;

import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.AddBillService;
import cn.mcandoird.service.impl.AddBillServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddSubmitServlet extends HttpServlet {
    private AddBillService addBillService=new AddBillServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charser=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
        String dateStr=req.getParameter("date");
        String moneyStr=req.getParameter("money");
        String pay_modeStr=req.getParameter("pay_mode");
        String typeStr=req.getParameter("type");
        String msgStr=req.getParameter("msg");
        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();

        Bill b=new Bill();
        if(dateStr!=null&&!dateStr.equals("")){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            try {
               b.setDate(format.parse(dateStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(moneyStr!=null&&!moneyStr.equals("")){
            double money=Double.parseDouble(moneyStr);
            b.setMoney(money);
        }


            b.setPay_mode(pay_modeStr);
            b.setType(typeStr);
            b.setMsg(msgStr);



        if(b!=null){
            if(addBillService.addBill(b)){
                map.put("succ","ok");
            }else {

                map.put("succ","err");
            }
            out.print(gson.toJson(map));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
