package com.lhx.servlet;

import com.lhx.util.FastJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhx on 14-12-9 下午4:19
 *
 * @project jspProject
 * @package ${PACKAGE_NAME}
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class JsonServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = null;
        try {
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            pw = response.getWriter();
//            String strResult = "{\"name\":\"li\",\"tel\":\"34254234234\",\"cg_name\":\"xin\"} ";
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            Map<String,String> map = new HashMap<String, String>();

            map.put("name","Link");
            map.put("num", "34");
            list.add(map);


            map = new HashMap<String, String>();
            map.put("name","Li");
            map.put("num", "123");

            map = new HashMap<String, String>();
            map.put("name","Tom");
            map.put("num", "76");
            list.add(map);

            map = new HashMap<String, String>();
            map.put("name","Gnk");
            map.put("num","583");
            list.add(map);

            String jsonstr = FastJsonUtil.object2json(list);

            pw.print(jsonstr);
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
        this.doPost(request, response);
    }
}
