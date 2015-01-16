package com.lhx.util;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhx on 14-12-9 上午10:30
 *
 * @project jspProject
 * @package com.lifeix.util
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
public class SolrGetFtTopic2 {
    private static final String SOLR_URL = "http://localhost:8080/solr/collection1";
//    private static final String SOLR_URL = "http://192.168.199.22:8080/ft_topic_core/";
//    private static final String SOLR_URL = "http://192.168.199.22:8080/sneakrole_core/";

    public String queryAll(String htmlWord){
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q","accountName:" + htmlWord + "*");
//        params.set("q","topic_name:"+htmlWord);
        params.set("start",0);
        params.set("rows",10);

        params.set("sort","score desc");
//        params.set("f1","topic_name,visit_num");
        params.set("f1","*,score");

        SolrServer server = new HttpSolrServer(SOLR_URL);

        List<Map<String,Object>> listWord = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = null ;
        try {
            QueryResponse response = server.query(params);
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                map = new HashMap<String, Object>();
                SolrDocument document = list.get(i);
                map.put("label",document.getFieldValue("l99NO") );
                map.put("value", document.getFieldValue("accountName"));
                listWord.add(map);
            }
            return  FastJsonUtil.object2json(listWord) ;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public String queryAll(String htmlWord, int start, int limit){
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q","accountName:" + htmlWord + "*");
        params.set("start", start);
        params.set("rows", limit);

        params.set("sort","score desc");
        params.set("f1","*,score");

        SolrServer server = new HttpSolrServer(SOLR_URL);

        List<Map<String,Object>> listWord = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = null ;
        try {
            QueryResponse response = server.query(params);
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                map = new HashMap<String, Object>();
                SolrDocument document = list.get(i);
                map.put("label",document.getFieldValue("l99NO") );
                map.put("value", document.getFieldValue("accountName"));
                listWord.add(map);
            }
            return  FastJsonUtil.object2json(listWord) ;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null ;
    }

    /**
     *
     * @param htmlWord 搜索关键词
     * @param start 开始
     * @param limit 每页条数
     * @param values  values[0]:查询字段,values[1],返回key值,values[2],返回value值
     * @return
     */
    public String queryAll(String htmlWord, int start, int limit, String... values){
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q",values[0] + ":" + htmlWord + "*");
        params.set("start", start);
        params.set("rows", limit);

        params.set("sort","score desc");
        params.set("f1","*,score");

        SolrServer server = new HttpSolrServer(SOLR_URL);

        List<Map<String,Object>> listWord = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = null ;
        try {
            QueryResponse response = server.query(params);
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                map = new HashMap<String, Object>();
                SolrDocument document = list.get(i);
                map.put("label",document.getFieldValue(values[1]) );
                map.put("value", document.getFieldValue(values[2]));
                listWord.add(map);
            }
            return  FastJsonUtil.object2json(listWord) ;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
