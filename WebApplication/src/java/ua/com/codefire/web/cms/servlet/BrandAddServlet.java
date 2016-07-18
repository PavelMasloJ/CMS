/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.cms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.web.cms.db.controller.BrandController;
import ua.com.codefire.web.cms.db.entity.Brand;
import ua.com.codefire.web.cms.db.entity.Phone;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns="/brand/add")
public class BrandAddServlet extends HttpServlet{
 private BrandController bc;
    @Override
    public void init() throws ServletException {
    bc = new BrandController();
    
    }
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        req.getRequestDispatcher("/WEB-INF/jsp/brand.edit.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String country = req.getParameter("country");
    
        Brand brand = new Brand(name, country);
        
        brand = bc.save(brand);

        resp.sendRedirect(req.getContextPath().concat("/brand/edit?id=" + brand.getId()));
    }
    
    
}
