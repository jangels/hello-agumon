package org.smallfire.java.utils.govhallStatistics;

import lombok.Data;

import java.util.List;

/**
 * @description 首都之窗-事项实体类
 * @author: Created by 韩晓明
 * @Date: 2018/8/23 14:07
 */
@Data
public class AffairEntity {
    private String id;
    private String title;
    private String zn_url;
    private String sb_url;
    private String yu_url;
    private String server_object;
    private String zt_type;
    private String zq_type;
    private String bm_type;
    private String xz_type;
    private String dx_type;
    private String ygzw_url;
    private String appointment;
    private String externalLink;
    private List<AffairEntity> son;

    private boolean kyy;//可预约
    private String type;//事项 列表
}
