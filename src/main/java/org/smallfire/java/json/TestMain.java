package org.smallfire.java.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/5/30.
 */
public class TestMain {

    public static void main(String[] args) {

        Wx wx = new Wx() ;
        wx.setTouser("touser");
        wx.setEmphasis_keyword("em");
        wx.setForm_id("form_id");
        wx.setPage("sss");
        wx.setToutemplate_idser("wx");


        Data data= new Data() ;
        Keyword keyword1 = new Keyword() ;
        keyword1.setColor("color");
        keyword1.setValue("sosoo");
        data.setKeyword1(keyword1);
        wx.setData(data);

        System.out.println(JSON.toJSONString(wx));
    }

}
