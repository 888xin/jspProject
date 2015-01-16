package com.lhx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lhx on 14-12-9 下午5:13
 *
 * @project jspProject
 * @package ${PACKAGE_NAME}
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class PhoneJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = null;
        try {
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            pw = response.getWriter();
            String strResult = "[{\"name\":\"苹果4代iphone正品\",\"num\":\"21782\"},{\"name\":\"苹果4代 手机套\",\"num\":\"238061\"},{\"name\":\"苹果4\",\"num\":\"838360\"}," +
                    "{\"name\":\"苹果皮\",\"num\":\"242721\"},{\"name\":\"苹果笔记本\",\"num\":\"63348\"},{\"name\":\"苹果4s\",\"num\":\"24030\"}]";
            String str = "[{\"name\":\"li\",\"age\":23},{\"name\":\"link\",\"age\":24},{\"name\":\"huang\",\"age\":27}]";
            pw.print(str);
            //System.out.println(strResult);
            pw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null)
                pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
