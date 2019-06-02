package cn.mcandoird.servlet;

import cn.mcandoird.Util.Util;
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

/**
 * @author LCQ
 * @version 1.0
 * @Date: 2018/12/18  22:34
 */
public class ChartPay_modeCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChartService service=new ChartServiceImpl();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        Gson gson=new Gson();

        out.print(gson.toJson(service.getCountByDate(new Date())));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
