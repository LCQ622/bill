package cn.mcandoird.servlet;

import cn.mcandoird.page.Page;
import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.PageService;
import cn.mcandoird.service.impl.PageServiceImpl;

import java.io.IOException;


public class Servlet extends javax.servlet.http.HttpServlet {
    private PageService pageService = new PageServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        String startstr = req.getParameter("start");
        String sizestr = req.getParameter("size");
        int start = 1;
        int size = 10;
        if (startstr != null && !startstr.equals("")) {
            if(Integer.parseInt(startstr)<=0){
                start=1;
            }else{
               start = Integer.parseInt(startstr);
            }

        }
        if (sizestr != null && !sizestr.equals("")) {
            size = Integer.parseInt(sizestr);
        }
        Page<Bill> page = pageService.showPage(start, size);

        req.setAttribute("page", page);
        req.getRequestDispatcher("01.jsp").forward(req, resp);
    }
}
