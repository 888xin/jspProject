package com.lhx.servlet;

import com.lhx.entity.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class AutoCompleteServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer sf = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sf.append("<message>");

        List<Word> list = new ArrayList<Word>(10);
        Word word = null ;
        for (int i = 0; i < 10; i++) {
            word = new Word(i, "abd" + i);
            list.add(word);
        }

        Iterator<Word> it = list.iterator();
        while (it.hasNext()){
            Word word1 = it.next();
            if (word1 == null){
                continue;
            }
            int number = word1.getNumber();
            String name = word1.getName();
            sf.append("<word>"+name);
            sf.append("</word>");
        }
        sf.append("</message>");
        PrintWriter pw = null;
        try {
            response.setContentType("text/xml;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            pw = response.getWriter();
            pw.print(sf.toString());
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
