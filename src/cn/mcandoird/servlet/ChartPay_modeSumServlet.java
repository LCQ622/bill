package cn.mcandoird.servlet;

import cn.mcandoird.service.ChartService;
import cn.mcandoird.service.impl.ChartServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LCQ
 * @version 1.0
 * @Date: 2018/12/18  21:44
 */
public class ChartPay_modeSumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChartService service = new ChartServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Map<String, Object>> list = service.getSumByDate(new Date());
        Gson gson=new Gson();
        out.print(gson.toJson(list));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
