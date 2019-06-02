package cn.mcandoird.servlet;

import cn.mcandoird.service.DelService;
import cn.mcandoird.service.impl.DelServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out =resp.getWriter();
        String idStr=req.getParameter("id");
        Map<String ,Object> map=new HashMap<>();
        if(idStr!=null&&!idStr.equals("")){
            int id =Integer.parseInt(idStr);
            DelService delService=new DelServiceImpl();
            if(delService.delBillById(id)){
                map.put("succ","ok");
                map.put("data",idStr);
            }else {
                map.put("succ","err");
                map.put("data",idStr);
                map.put("msg","É¾³ýÊ§°Ü£¡");
            }


        }

        Gson gson =new Gson();
        out.print(gson.toJson(map));
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {






    }
}
