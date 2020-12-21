package com.demo.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-11 17:01
 */
@Slf4j
public class CodeGeneration {

    public static void main(String[] args) {
        //全局策略配置
        GlobalConfig config = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true)
                //作者注释
                .setAuthor("taoweipu")
                //输出路径
                .setOutputDir("D:\\tao\\studyworkspace\\demo_parent\\user\\src\\main\\java")
                //覆盖已有文件，默认false
                .setFileOverride(false)
                //是否打开输出目录窗口。默认true
                .setOpen(false)
                //是否在xml中添加二级缓存配置。默认false
                //.setEnableCache(true)
                //开启kotlin模式，默认false
                //.setKotlin(false)
                //开启swagger2模式
                .setSwagger2(true)
                //开启ActiveRecord模式
                .setActiveRecord(true)
                //mapper添加restMap
                .setBaseResultMap(true)
                //mapper添加Base_Column_List
                .setBaseColumnList(true)
                //时间类型对应策略，默认time_pack
                //.setDateType(DateType.TIME_PACK)
                .setMapperName("%sDao")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl");
        //.setIdType(IdType.ASSIGN_ID)

        // .setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai")
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.POSTGRE_SQL)
                .setDriverName("org.postgresql.Driver").setUrl("jdbc:postgresql://192.168.209.129:5432/twp_db?characterEncoding=utf-8")
                .setUsername("postgres")
                .setPassword("123456");
        //数据库信息查询类，默认由dbType类型决定，实现IDbQuery接口可自定义数据库查询sql
        //.setDbQuery()
        //不知道干嘛的，官网写的是public，我改成其他都没有发现变化
        //.setSchemaName("private")
        //内置转换类型，默认由dbType类型决定。可实现或重写实现了 IColumnType 接口的类，自定义转换为自己需要的 java 类型
        //.setTypeConvert(new MySqlTypeConvert())

        //数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategyConfig = new StrategyConfig();
        //是否大写命名
        strategyConfig.setCapitalMode(true)
                //是否跳过视图
                .setSkipView(true)
                //数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //数据库表字段映射到实体的命名策略，未指定按照naming执行
                //.setColumnNaming(NamingStrategy.no_change)
                //生成表
                .setInclude("user_info", "user_role")
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(true);

        //包名配置
        PackageConfig packageConfig = new PackageConfig();
        //父包名
        packageConfig.setParent("com.demo.baomidou")
                .setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");

        //自定义模板配置
        //TemplateConfig templateConfig = new TemplateConfig();
        //templateConfig.setEntity("/templates/entity.java");

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setStrategy(strategyConfig)
                .setDataSource(dataSourceConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
        log.info("=============代码生成成功================");
    }
}
