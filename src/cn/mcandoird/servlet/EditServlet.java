package cn.mcandoird.servlet;

import cn.mcandoird.pojo.Bill;
import cn.mcandoird.service.EditService;
import cn.mcandoird.service.impl.EditServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditService editService=new EditServiceImpl();
        String IdStr=request.getParameter("id");

        if(IdStr!=null&&!IdStr.equals("")){
            int id =Integer.parseInt(IdStr);
            Bill bill= editService.getBillById(id);
            request.setAttribute("bill",bill);
        }
        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }
}
