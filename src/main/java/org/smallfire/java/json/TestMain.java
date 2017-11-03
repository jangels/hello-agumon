package org.smallfire.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bjtoon.framework.sdk.toon.tooncode.ToonDesUtils;
import com.zhengtoon.bjtoon.conv.bean.ConfigDict;
import com.zhengtoon.bjtoon.conv.bean.ConvAttachment;
import com.zhengtoon.bjtoon.conv.bean.toonCode.VisitorInfo;
import com.zhengtoon.bjtoon.conv.utils.AppConstant;
import com.zhengtoon.bjtoon.conv.utils.CloudAppUtils;
import com.zhengtoon.bjtoon.conv.utils.ZipUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
