package com.clinbrain.datac.util;

import com.clinbrain.datac.common.schema.Column;
import com.clinbrain.datac.model.custom.ColumnEntity;
import com.clinbrain.datac.model.custom.TableEntity;
import com.clinbrain.datac.model.custom.TsysTables;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代码生成器   工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午11:40:24
 */
public class GenUtils {

  private static final Logger LOG = LoggerFactory.getLogger(GenUtils.class);

  private static final Template modelTpl;
  static {
      //设置velocity资源加载器
      Properties prop = new Properties();
      prop.put("file.resource.loader.class",
              "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
      Velocity.init(prop);

      //获取模板列表
      String template = "generator/template/model/Entity.java.vm";
      modelTpl = Velocity.getTemplate(template, "UTF-8");
  }

  public static List<String> getTemplates() {
    List<String> templates = new ArrayList<String>();
    //templates.add("generator/template/model/Entity.java.vm");
    /*templates.add("generator/template/Dao.java.vm");
    templates.add("generator/template/Dao.xml.vm");
    templates.add("generator/template/Service.java.vm");
    templates.add("generator/template/ServiceImpl.java.vm");
    templates.add("generator/template/Controller.java.vm");
    templates.add("generator/template/menu.sql.vm");

    templates.add("generator/template/index.vue.vm");
    templates.add("generator/template/add-or-update.vue.vm");*/

    templates.add("generator/template/model/Entity.java.vm");
    templates.add("generator/template/model/EntityExample.java.vm");
    templates.add("generator/template/mapperxml/EntityMapper.xml.vm");
    templates.add("generator/template/service/EntityService.java.vm");
    templates.add("generator/template/mapper/EntityMapper.java.vm");
    templates.add("generator/template/controller/EntityController.java.vm");
    templates.add("generator/template/sql/menu.sql.vm");
    templates.add("generator/template/html/list.html.vm");
    templates.add("generator/template/html/add.html.vm");
    templates.add("generator/template/html/edit.html.vm");
    return templates;
  }

  /**
   * 生成java 类，
   * @param tableName  表名
   * @param columns 列信息
   * @return <包名,类名,类源码>
   */
  public static Triple<String,String,String> generatorCode(String tableName,
      List<Column> columns) {
    //配置信息
    Configuration config = getConfig();
    boolean hasBigDecimal = false;
    //判断主键
    boolean pklag = false;
    //表信息
    TableEntity tableEntity = new TableEntity();
    tableEntity.setTableName(tableName);
    tableEntity.setComments(tableName);
    //表名转换成Java类名
    String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
    tableEntity.setClassName(className);
    tableEntity.setClassname(StringUtils.uncapitalize(className));

    //列信息
    List<ColumnEntity> columsList = new ArrayList<>();
    for (Column column : columns) {
      ColumnEntity columnEntity = new ColumnEntity();
      columnEntity.setColumnName(column.getName());
      columnEntity.setDataType(column.getDataTypeName());
      columnEntity.setComments(column.getComment());
      columnEntity.setExtra("");

      //列名转换成Java属性名
      String attrName = columnToJava(columnEntity.getColumnName());
      String attrname = StringUtils.uncapitalize(attrName);
      columnEntity.setAttrName(attrName);
      columnEntity.setAttrname(attrname);
      columnEntity.setRealName(attrname);
      if(com.clinbrain.datac.util.StringUtils.isJavaSpecialName(StringUtils.lowerCase(attrname))) {
          columnEntity.setReserved(true);
          columnEntity.setAttrname(attrname + "2");
          columnEntity.setAttrName(attrName + "2");
      }

      //列的数据类型，转换成Java类型, 这里根据要比对的源和目标数据类型不一直导致的数据显示问题，统一使用String 来作为数据类型
      String attrType = "String";//config.getString(columnEntity.getDataType(), "String");
      columnEntity.setAttrType(attrType);
      /*if (!hasBigDecimal && attrType.equals("BigDecimal")) {
        hasBigDecimal = true;
      }*/
      //是否主键
      if (column.isPrimaryKey()) {
          columnEntity.setPrimaryKey(true);
        tableEntity.setPk(columnEntity);
        pklag = true;
      }

      columsList.add(columnEntity);
    }
    tableEntity.setColumns(columsList);

    //没主键，则第一个字段为主键
    if (tableEntity.getPk() == null) {
      tableEntity.setPk(tableEntity.getColumns().get(0));
    }

    String columnsStr = "";
    List<String> columnsList = new ArrayList<String>();
    List<ColumnEntity> columnEntities = tableEntity.getColumns();
    for (ColumnEntity columnEntity : columnEntities) {
      columnsList.add(columnEntity.getColumnName());
    }
    columnsStr = String.join(",", columnsList);

    String mainPath = config.getString("mainPath");
    mainPath = StringUtils.isBlank(mainPath) ? "com.clinbrain.datac" : mainPath;
    //封装模板数据
    Map<String, Object> map = new HashMap<>();
    map.put("tableName", tableEntity.getTableName());
    map.put("comments", tableEntity.getComments());
    map.put("pklag", pklag);
    map.put("pk", tableEntity.getPk());
    map.put("className", tableEntity.getClassName());
    map.put("classname", tableEntity.getClassname());
    map.put("pathName", tableEntity.getClassname().toLowerCase());
    map.put("columns", tableEntity.getColumns());
    map.put("columnsStr", columnsStr);
    map.put("hasBigDecimal", hasBigDecimal);
    map.put("mainPath", mainPath);
    map.put("package", config.getString("package"));
    map.put("moduleName", config.getString("moduleName"));
    map.put("controller", config.getString("controller"));
    map.put("author", config.getString("author"));
    map.put("email", config.getString("email"));
    map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
    map.put("SnowflakeIdWorker", SnowflakeIdWorker.class);
    map.put("fuzzyQuery", config.getString("fuzzyQuery"));
    VelocityContext context = new VelocityContext(map);

    //渲染模板
    StringWriter sw = new StringWriter();
      modelTpl.merge(context, sw);
    String stringBuffer = sw.toString();
    try {
      sw.close();
    } catch (IOException e) {
      LOG.error("创建Pojo Bean JAVA 文件失败", e);
    }
    return new MutableTriple<>(map.get("package")+"." +map.get("moduleName"),
        tableEntity.getClassName(),stringBuffer);
  }

  /**
   * 生成代码
   */
  public static void generatorCode(TsysTables table, List<Map<String, String>> columns,
      ZipOutputStream zip) {
    //配置信息
    Configuration config = getConfig();
    boolean hasBigDecimal = false;
    //判断主键
    boolean pklag = false;
    //表信息
    TableEntity tableEntity = new TableEntity();
    tableEntity.setTableName(table.getTableName());
    tableEntity.setComments(table.getTableComment());
    //表名转换成Java类名
    String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
    tableEntity.setClassName(className);
    tableEntity.setClassname(StringUtils.uncapitalize(className));

    //列信息
    List<ColumnEntity> columsList = new ArrayList<>();
    for (Map<String, String> column : columns) {
      ColumnEntity columnEntity = new ColumnEntity();
      columnEntity.setColumnName(column.get("columnName"));
      columnEntity.setDataType(column.get("dataType"));
      columnEntity.setComments(column.get("columnComment"));
      columnEntity.setExtra(column.get("extra"));

      //列名转换成Java属性名
      String attrName = columnToJava(columnEntity.getColumnName());
      columnEntity.setAttrName(attrName);
      columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

      //列的数据类型，转换成Java类型
      String attrType = config.getString(columnEntity.getDataType(), "unknowType");
      columnEntity.setAttrType(attrType);
      if (!hasBigDecimal && attrType.equals("BigDecimal")) {
        hasBigDecimal = true;
      }
      //是否主键
      if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
        tableEntity.setPk(columnEntity);
        pklag = true;
      }

      columsList.add(columnEntity);
    }
    tableEntity.setColumns(columsList);

    //没主键，则第一个字段为主键
    if (tableEntity.getPk() == null) {
      tableEntity.setPk(tableEntity.getColumns().get(0));
    }

    String columnsStr = "";
    List<String> columnsList = new ArrayList<String>();
    List<ColumnEntity> columnEntities = tableEntity.getColumns();
    for (ColumnEntity columnEntity : columnEntities) {
      columnsList.add(columnEntity.getColumnName());
    }
    columnsStr = String.join(",", columnsList);
    //设置velocity资源加载器
    Properties prop = new Properties();
    prop.put("file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    Velocity.init(prop);
    String mainPath = config.getString("mainPath");
    mainPath = StringUtils.isBlank(mainPath) ? "com.clinbrain.datac" : mainPath;
    //封装模板数据
    Map<String, Object> map = new HashMap<>();
    map.put("tableName", tableEntity.getTableName());
    map.put("comments", tableEntity.getComments());
    map.put("pklag", pklag);
    map.put("pk", tableEntity.getPk());
    map.put("className", tableEntity.getClassName());
    map.put("classname", tableEntity.getClassname());
    map.put("pathName", tableEntity.getClassname().toLowerCase());
    map.put("columns", tableEntity.getColumns());
    map.put("columnsStr", columnsStr);
    map.put("hasBigDecimal", hasBigDecimal);
    map.put("mainPath", mainPath);
    map.put("package", config.getString("package"));
    map.put("moduleName", config.getString("moduleName"));
    map.put("controller", config.getString("controller"));
    map.put("author", config.getString("author"));
    map.put("email", config.getString("email"));
    map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
    map.put("SnowflakeIdWorker", SnowflakeIdWorker.class);
    map.put("fuzzyQuery", config.getString("fuzzyQuery"));
    VelocityContext context = new VelocityContext(map);

    //获取模板列表
    List<String> templates = getTemplates();
    for (String template : templates) {
      //渲染模板
      StringWriter sw = new StringWriter();
      Template tpl = Velocity.getTemplate(template, "UTF-8");
      tpl.merge(context, sw);

      try {
        //添加到zip
        zip.putNextEntry(new ZipEntry(
            getFileName(template, tableEntity.getClassname(), tableEntity.getClassName(),
                config.getString("package"), config.getString("moduleName"),
                config.getString("controller"))));
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.closeEntry();
      } catch (IOException e) {
        try {
          throw new Exception("渲染模板失败，表名：" + tableEntity.getTableName() + "\n" + e.getMessage());
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }


  /**
   * 列名转换成Java属性名
   */
  public static String columnToJava(String columnName) {
    return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
  }

  /**
   * 表名转换成Java类名
   */
  public static String tableToJava(String tableName, String tablePrefix) {
    if (StringUtils.isNotBlank(tablePrefix)) {
      tableName = tableName.replaceFirst(tablePrefix, "");
    }
    return columnToJava(tableName);
  }

  /**
   * 获取配置信息
   */
  public static Configuration getConfig() {
    try {
      return new PropertiesConfiguration("generator/generator.properties");
    } catch (ConfigurationException e) {
      System.out.println("获取配置文件失败");
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 获取文件名
   */
  public static String getFileName(String template, String classname, String className,
      String packageName, String moduleName, String controller) {
    String packagePath = "main" + File.separator + "java" + File.separator;
    if (StringUtils.isNotBlank(packageName)) {
      packagePath += packageName.replace(".", File.separator) + File.separator;
    }

    if (template.contains("Entity.java.vm")) {//model
      return packagePath + moduleName + File.separator + "auto" + File.separator + className
          + ".java";
    }
    if (template.contains("EntityExample.java.vm")) {//modelExample
      return packagePath + moduleName + File.separator + "auto" + File.separator + className
          + "Example.java";
    }

    if (template.contains("EntityMapper.java.vm")) {//dao or  mapper
      return packagePath + "mapper" + File.separator + "auto" + File.separator + className
          + "Mapper.java";
    }
    if (template.contains("EntityMapper.xml.vm")) {//dao or  mapper
      return "mybatis" + File.separator + "auto" + File.separator + className + "Mapper.xml";
    }

    if (template.contains("EntityService.java.vm")) {
      return packagePath + "service" + File.separator + className + "Service.java";
    }
    if (template.contains("EntityController.java.vm")) {
      return packagePath + "controller" + File.separator + controller + File.separator + className
          + "Controller.java";
    }
    if (template.contains("menu.sql.vm")) {
      return "menu.sql";
    }
    if (template.contains("list.html.vm")) {
      return "html" + File.separator + classname + File.separator + "/list.html";
    }
    if (template.contains("add.html.vm")) {
      return "html" + File.separator + classname + File.separator + "/add.html";
    }
    if (template.contains("edit.html.vm")) {
      return "html" + File.separator + classname + File.separator + "/edit.html";
    }

//        if (template.contains("ServiceImpl.java.vm" )) {
//            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
//        }
//
//        if (template.contains("Controller.java.vm" )) {
//            return packagePath + "controller" + File.separator + className + "Controller.java";
//        }
//
//        if (template.contains("Dao.xml.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
//        }
//
//        if (template.contains("menu.sql.vm" )) {
//            return className.toLowerCase() + "_menu.sql";
//        }
//
//        if (template.contains("index.vue.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
//                    File.separator + moduleName + File.separator + className.toLowerCase() + ".vue";
//        }
//
//        if (template.contains("add-or-update.vue.vm" )) {
//            return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
//                    File.separator + moduleName + File.separator + className.toLowerCase() + "-add-or-update.vue";
//        }

    return null;
  }
}
