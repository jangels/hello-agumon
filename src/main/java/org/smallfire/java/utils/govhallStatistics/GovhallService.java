package org.smallfire.java.utils.govhallStatistics;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.collections.CollectionUtils;
import org.smallfire.java.utils.http.HttpUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description 政务大厅爬取所有信息
 * @author: Created by 韩晓明
 * @Date: 2018/8/23 09:16
 */
public class GovhallService {
    // 地区url
    public static final String AREA_URL = "http://banshi.beijing.gov.cn/pubservice_mobile/api/district/getList";
    // 事项URL
    public static final String AFFAIR_URL = "http://banshi.beijing.gov.cn/pubservice_mobile/api/affair/getAffairList";
    // 事项分类URL
    public static final String AFFAIR_FL_URL = "http://banshi.beijing.gov.cn/pubservice_mobile/api/affair/getTypeList";

    //    1.获取地区
    public static JSONArray getArea() {
        JSONArray jsonArray = new JSONArray();
        String result = "";
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("parentId", "0");
            result = syncGet(AREA_URL, null, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(result)) {
            JSONObject json = JSONObject.parseObject(result);
            jsonArray.addAll(json.getJSONArray("data"));
        }

        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("parentId", "18");
            result = syncGet(AREA_URL, null, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(result)) {
            JSONObject json = JSONObject.parseObject(result);
            jsonArray.addAll(json.getJSONArray("data"));
        }

        System.out.println(jsonArray);
        return jsonArray;
    }

    //    2.根据地区获取事项
    public static List<ExcelSheetDTO> getSubject(JSONArray jsonArray) {
        List<ExcelSheetDTO> excel = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                String result = "";
                String resultFL1 = "";
                String resultFL2 = "";
                try {
                    //事项
                    Map<String, String> map = new HashMap<>();
                    map.put("pageNum", "1");
                    map.put("pageSize", "5000");
                    map.put("serviceId", "0");
                    map.put("affairListUrl", jsonArray.getJSONObject(i).getString("lb_url"));
                    result = syncGet(AFFAIR_URL, null, map);
                    System.out.println("完成获取数据：" + jsonArray.getJSONObject(i).getString("name"));
                    //分类
                    map = new HashMap<>();
                    map.put("serviceId", "1001");
                    map.put("typeListUrl", jsonArray.getJSONObject(i).getString("fl_url"));
                    resultFL1 = syncGet(AFFAIR_FL_URL, null, map);
                    System.out.println("完成个人分类获取数据：" + jsonArray.getJSONObject(i).getString("name"));

                    map.put("serviceId", "1002");
                    resultFL2 = syncGet(AFFAIR_FL_URL, null, map);
                    System.out.println("完成法人分类获取数据：" + jsonArray.getJSONObject(i).getString("name"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONArray array = JSONObject.parseObject(result).getJSONObject("data").getJSONArray("result");
                List<AffairEntity> list = array.toJavaList(AffairEntity.class);

                JSONObject fl1 = JSONObject.parseObject(resultFL1).getJSONObject("data");
                JSONObject fl2 = JSONObject.parseObject(resultFL2).getJSONObject("data");
//                JSONObject fl1 = new JSONObject();
//                JSONObject fl2 = new JSONObject();
                Map<String, String> organization = getFL(fl1, fl2, "organization");
                Map<String, String> affairType = getFL(fl1, fl2, "affairType");
                Map<String, String> subject = getFL(fl1, fl2, "subject");
                Map<String, String> object = getFL(fl1, fl2, "object");
                Map<String, String> lifeCycle = getFL(fl1, fl2, "lifeCycle");


                ArrayList<ArrayList<String>> row = setRowExcel(list, organization, affairType, subject, object, lifeCycle);
                ExcelSheetDTO sheetDTO = new ExcelSheetDTO();
                sheetDTO.setSheetName(jsonArray.getJSONObject(i).getString("name"));
                sheetDTO.setData(row);
                excel.add(sheetDTO);
            }
        }
        return excel;
    }

    //    3.获取事项输出到Excel中
    public static ArrayList<ArrayList<String>> setRowExcel(List<AffairEntity> array,
                                                           Map<String, String> organization,
                                                           Map<String, String> affairType,
                                                           Map<String, String> subject,
                                                           Map<String, String> object,
                                                           Map<String, String> lifeCycle) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        //title
        ArrayList<String> title = new ArrayList<>();
        title.add("类型");
        title.add("是否可预约");
        title.add("id");
        title.add("标题");
        title.add("指南");
        title.add("申报");
        title.add("预约url");
        title.add("个人法人");
        title.add("主题");
        title.add("周期");
        title.add("部门");
        title.add("性质");
        title.add("对象");
        result.add(title);

        for (AffairEntity entity : array) {
            if (CollectionUtils.isEmpty(entity.getSon())) {
                //事项
                ArrayList<String> row = getAffairEntity(entity, false, organization, affairType, subject, object, lifeCycle);
                result.add(row);
            } else {
                //列表
                ArrayList<String> row = getAffairEntity(entity, true, organization, affairType, subject, object, lifeCycle);
                result.add(row);

                for (int i = 0; i < entity.getSon().size(); i++) {
                    ArrayList<String> row2 = getAffairEntity(entity.getSon().get(i), false, organization, affairType, subject, object, lifeCycle);
                    result.add(row2);
                }
            }
        }
        return result;

    }

    /**
     * @param fl1 个人分类
     * @param fl2 法人分类
     */
    private static Map<String, String> getFL(JSONObject fl1, JSONObject fl2, String key) {
        JSONArray subjectArray1 = fl1.getJSONArray(key);
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < subjectArray1.size(); i++) {
            String id = subjectArray1.getJSONObject(i).getString("id");
            String name = subjectArray1.getJSONObject(i).getString("name");
            data.put(id, name);
        }
        JSONArray subjectArray2 = fl2.getJSONArray(key);
        for (int i = 0; i < subjectArray2.size(); i++) {
            String id = subjectArray2.getJSONObject(i).getString("id");
            String name = subjectArray2.getJSONObject(i).getString("name");
            data.put(id, name);
        }
        return data;

    }


    /**
     * @param entity 数据
     * @param isLb   是否列表
     * @return
     */
    private static ArrayList<String> getAffairEntity(AffairEntity entity, boolean isLb,
                                                     Map<String, String> organization,
                                                     Map<String, String> affairType,
                                                     Map<String, String> subject,
                                                     Map<String, String> object,
                                                     Map<String, String> lifeCycle) {


        ArrayList<String> row = new ArrayList<>();
        if (isLb) {
            row.add("列表");
        } else {
            row.add("事项");
        }
        row.add(((!"".equals(entity.getId())) && entity.getId().equals(entity.getYu_url())) + "");
        row.add(entity.getId());
        row.add(entity.getTitle());
        row.add(entity.getZn_url());
        row.add(entity.getSb_url());
        row.add(entity.getYu_url());
        row.add(entity.getServer_object().replace("1001", "个人服务").replace("1002", "法人服务"));


        row.add(getMaps(entity.getZt_type(), subject));
        row.add(getMaps(entity.getZq_type(), lifeCycle));
        row.add(getMaps(entity.getBm_type(), organization));
        row.add(getMaps(entity.getXz_type(), affairType));
        row.add(getMaps(entity.getDx_type(), object));
        return row;
    }

    /**
     * 匹配
     */
    private static String getMaps(String key, Map<String, String> data) {
        if (StringUtils.isEmpty(key)) {
            return key;
        }
        String[] keys = key.split("、");
        String result = "";
        for (int i = 0; keys != null && i < keys.length; i++) {
            if (!StringUtils.isEmpty(keys[i])) {
                if (i == keys.length - 1) {
                    result += data.get(keys[i]) == null ? keys[i] : data.get(keys[i]);
                } else {
                    result += data.get(keys[i]) == null ? keys[i] : data.get(keys[i]) + "、";
                }
            }
        }
        return result;
    }

    private static ExcelSheetDTO count(List<ExcelSheetDTO> data) {
        ExcelSheetDTO sheetDTO = new ExcelSheetDTO();
        sheetDTO.setSheetName("统计");

        ArrayList<ArrayList<String>> result = new ArrayList<>();
//        地区	事项	预约	个人事项	法人事项	个人预约	法人预约
        ArrayList<String> countTitle = new ArrayList<>();
        countTitle.add("地区");
        countTitle.add("事项");
        countTitle.add("预约");
        countTitle.add("个人事项");
        countTitle.add("法人事项");
        countTitle.add("个人预约");
        countTitle.add("法人预约");
        result.add(countTitle);

        for (ExcelSheetDTO excel : data) {
            ArrayList<ArrayList<String>> list = excel.getData();
            //事项
            long sx = list.stream().filter(h1 -> "事项".equals(h1.get(0))).count();
//            预约
            long yy = list.stream().filter(h1 -> "事项".equals(h1.get(0)) && "true".equals(h1.get(1))).count();
            //个人事项 7
            long grsx = list.stream().filter(h1 -> "事项".equals(h1.get(0)) && !"法人服务".equals(h1.get(7))).count();
            //法人事项 7
            long frsx = list.stream().filter(h1 -> "事项".equals(h1.get(0)) && !"个人服务".equals(h1.get(7))).count();
            //个人预约
            long gryy = list.stream().filter(h1 -> "事项".equals(h1.get(0)) && "true".equals(h1.get(1)) && !"法人服务".equals(h1.get(7))).count();
            //法人预约
            long fryy = list.stream().filter(h1 -> "事项".equals(h1.get(0)) && "true".equals(h1.get(1)) && !"个人服务".equals(h1.get(7))).count();
            ArrayList<String> count = new ArrayList<>();
            count.add(excel.getSheetName());
            count.add(sx + "");
            count.add(yy + "");
            count.add(grsx + "");
            count.add(frsx + "");
            count.add(gryy + "");
            count.add(fryy + "");
            result.add(count);
        }

        sheetDTO.setData(result);
        return sheetDTO;
    }

    /**
     * get请求
     *
     * @author jyx
     */
    public static String syncGet(String url, Headers headers, Map paramMap) throws IOException {
        Response reponse = HttpUtils.syncGet(url, headers, paramMap);
        ResponseBody reponseBody = reponse.body();
        String result = reponseBody.string();
        return result;
    }

    public static void main(String[] args) throws IOException {
        JSONArray jsonArray = getArea();
        List<ExcelSheetDTO> data = getSubject(jsonArray);
        ExcelSheetDTO countList = count(data);

        data.add(0,countList);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String time = sdf.format(date);
        String path = "F:\\政务大厅事项统计_" + time + ".xls";
        Excel.writer(data, path);
    }
}
