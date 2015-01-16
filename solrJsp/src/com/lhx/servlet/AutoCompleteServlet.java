package com.lhx.servlet;

import com.lhx.entity.Word;
import com.lhx.util.SolrGetFtTopic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lhx on 14-12-9 上午9:31
 *
 * @project jspProject
 * @package ${PACKAGE_NAME}
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class AutoCompleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //获取网页上文本框输入的内容
//        String htmlWord = request.getParameter("word");
//
//
//        StringBuffer sf = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        sf.append("<message>");
//        SolrGetFtTopic solrGetFtTopic = new SolrGetFtTopic();
//        //传入参数，根据参数来进行搜索
//        List<Word> list = solrGetFtTopic.queryAll(htmlWord);
//        Iterator<Word> it = list.iterator();
//        while (it.hasNext()){
//            Word word1 = it.next();
//            if (word1 == null){
//                continue;
//            }
//            String name = word1.getName();
//            sf.append("<word>"+name);
//            sf.append("</word>");
//        }
//        sf.append("</message>");
//        PrintWriter pw = null;
//        try {
//            response.setContentType("text/xml;charset=utf-8");
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("Cache-Control", "no-cache");
//            pw = response.getWriter();
//            pw.print(sf.toString());
//            pw.flush();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (pw != null)
//                pw.close();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
