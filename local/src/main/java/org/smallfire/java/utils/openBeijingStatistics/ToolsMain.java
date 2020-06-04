package org.smallfire.java.utils.openBeijingStatistics;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.smallfire.java.utils.http.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzh on 2018/12/27.
 */
public class ToolsMain {

    private static String query_type_url = "http://openbeijing.gov.cn/openbj/service/getServiceType";
    private static String type_list_url = "http://openbeijing.gov.cn/openbj/service/getAllServiceType";
    private static String child_list_url = "http://openbeijing.gov.cn/openbj/service/getServiceInfoByTypeId";

    public static void main(String[] args) throws IOException {
        // 获取类型
        // 获取类型下事项列表
        // 获取事项下子事项列表
        // 导出excel

        Map<String,String> allTypeParam = new HashMap<>();
        allTypeParam.put("typeName","货物贸易");
        String responseAllType = HttpUtils.syncFormPostString(query_type_url,null,allTypeParam);

        JSONObject responseData = JSON.parseObject(responseAllType,JSONObject.class);
        String responseString = responseData.getString("data");
        List<JSONObject> dataList = JSON.parseArray(responseString,JSONObject.class);

        List<OpenType> result = new ArrayList<>();
        for(JSONObject item:dataList){
            List<TypeList> typeList = new ArrayList<>();

            String typeCode = item.getString("typeCode");
            String typeName = item.getString("typeName");
            OpenType openType = new OpenType();
            openType.setTypeName(typeName);
            openType.setTypeList(typeList);
            result.add(openType) ;

            Map<String,String> typeListParam = new HashMap<>();
            typeListParam.put("typeCode",typeCode);
            String responseTypeList = HttpUtils.syncFormPostString(type_list_url,null,typeListParam);
            JSONObject responseListData = JSON.parseObject(responseTypeList,JSONObject.class);
            String responseListString = responseListData.getString("data");
            List<JSONObject> typeListData = JSON.parseArray(responseListString,JSONObject.class);

            for(JSONObject item1:typeListData){
                TypeList typeList1 = new TypeList();
                String typeId =item1.getString("id");
                typeList1.setTypeDetailName(item1.getString("matterName"));

                List<String> childDetailList = new ArrayList<>();
                typeList1.setChildDetailList(childDetailList);

                typeList.add(typeList1);


                Map<String,String> childParam = new HashMap<>();
                childParam.put("typeId",typeId);

                String responseChild = HttpUtils.syncFormPostString(child_list_url,null,childParam);
                JSONObject responseChildData = JSON.parseObject(responseChild,JSONObject.class);
                String responseChildString = responseChildData.getString("data");
                List<JSONObject> childData = JSON.parseArray(responseChildString,JSONObject.class);

                for(JSONObject item2:childData){
                    String childName = item2.getString("serviceClassification");
                    childDetailList.add(childName);
                }
            }

        }

        String path="F:\\开放北京.xls";
        ExcelOpen.writer(result,path);
    }
}
