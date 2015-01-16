package com.lhx.servlet;

import com.lhx.util.SolrGetFtTopic2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by lhx on 14-12-10 下午5:29
 *
 * @project jspProject
 * @package ${PACKAGE_NAME}
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class JsonSolrServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取网页上文本框输入的内容
        String htmlWord = request.getParameter("term").trim();

        String jsonStr = "" ;
        SolrGetFtTopic2 solrGetFtTopic = new SolrGetFtTopic2();
        if (!"".equals(htmlWord) && htmlWord != null){
            //传入参数，根据参数来进行搜索
            jsonStr = solrGetFtTopic.queryAll(htmlWord);
        }

        PrintWriter pw = null;
        try {
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            pw = response.getWriter();
            pw.print(jsonStr);
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
        this.doPost(request,response);
    }
}
