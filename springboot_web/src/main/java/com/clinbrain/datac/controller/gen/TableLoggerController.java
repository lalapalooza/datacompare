package com.clinbrain.datac.controller.gen;

import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.custom.TableSplitResult;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.model.custom.TitleVo;
import com.clinbrain.datac.service.TableLoggerService;
import io.swagger.annotations.Api;

import java.io.*;
import java.util.Date;

@Controller
@RequestMapping("TableLoggerController")
@Api(value = "")
public class TableLoggerController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(TableLoggerController.class);

    private String prefix = "admin/tableLogger";
    @Autowired
    private TableLoggerService tableLoggerService;

    @Value("${log.path}")
    private String logPath;

    private final String logFileName = "data-compare-default.log";

    @GetMapping("view")
    @RequiresPermissions("model:tableLogger:view")
    public String view(Model model) {
        String str = "";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return prefix + "/list";
    }


    @PostMapping("list")
    @RequiresPermissions("model:tableLogger:list")
    @ResponseBody
    public Object list(Tablepar tablepar) {
        PageInfo<TableLoggerWithBLOBs> page = tableLoggerService.list(tablepar);
        TableSplitResult<TableLoggerWithBLOBs> result = new TableSplitResult<>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 新增
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        return prefix + "/add";
    }


    @PostMapping("add")
    @RequiresPermissions("model:tableLogger:add")
    @ResponseBody
    public AjaxResult add(TableLoggerWithBLOBs tableLogger, Model model) {
        int b = tableLoggerService.insertSelective(tableLogger);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping("remove")
    @RequiresPermissions("model:tableLogger:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = tableLoggerService.deleteByPrimaryKey(ids);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 修改跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TableLoggerWithBLOBs logger = tableLoggerService.selectByPrimaryKey(id);
        String loggerFile = logger.getLoggerFile();

        mmap.put("TableLogger", logger);
        mmap.put("logs", readFile(loggerFile));

        return prefix + "/edit";
    }

    @RequestMapping(value = "/log",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String log(String log) {
        return readFile(log);
    }

    @GetMapping("/sysLog")
    public String sysLog(ModelMap modelMap){
        String saveLogPath = logPath + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "/" + logFileName;
        modelMap.put("logs",readFile(saveLogPath));
        return prefix + "/sysLog";
    }

    @RequestMapping(value = "/sysLog/refresh",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String sysLogRefresh(){
        String saveLogPath = logPath + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "/" + logFileName;
        return readFile(saveLogPath);
    }

    private String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            File file = new File(filePath);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\r\n");
                }

            }
        } catch (Exception e) {
            stringBuilder.append("读取文件出错（").append(filePath).append("）:").append(e.getMessage());
        }
        return stringBuilder.toString();
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("model:tableLogger:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TableLoggerWithBLOBs record) {
        return toAjax(tableLoggerService.updateByPrimaryKeySelective(record));
    }


}
