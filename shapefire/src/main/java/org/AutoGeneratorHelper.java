package org;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 自动生成映射工具类
 *
 * @author cos-lzh
 */
public class AutoGeneratorHelper {

    /**
     * <p>
     * 测试 run 执行
     * </p>
     * <p>
     * 更多使用查看 http://mp.baomidou.com
     * </p>
     */
    public static void main(String[] args) {

        // 用来获取Mybatis-Plus.properties文件的配置信息
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        gc.setOutputDir(System.getProperty("user.dir") + "/gen/src/main/java");
//        gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");

        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("cos-lzh");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("syswin");
        dsc.setPassword("syswin");
        dsc.setUrl("jdbc:mysql://172.28.5.92:3306/cos_open_platform?useUnicode=true&characterEncoding=utf-8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(new String[]{"new_video"});
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setEntityColumnConstant(true);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        // 自定义包路径
        pc.setParent("org.smallfire");
        // 这里是控制器包名，默认
        pc.setController("controller");
        pc.setEntity("data.entity");
        pc.setMapper("repository");
        pc.setXml("mapping");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }

}
