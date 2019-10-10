package com.clinbrain.datac.controller.gen;

import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableConfigExample;
import com.clinbrain.datac.model.custom.TableSplitResult;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.model.custom.TitleVo;
import com.clinbrain.datac.service.TableConfigService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TableConfigController")
@Api(value = "")
public class TableConfigController extends BaseController{
	
	private String prefix = "admin/tableConfig";
	@Autowired
	private TableConfigService tableConfigService;

	@GetMapping("view")
	@RequiresPermissions("model:tableConfig:view")
    public String view(Model model)
    {	
		String str="数据比对配置";
		setTitle(model, new TitleVo("列表", str+"管理", true,"用来配置需要比对的数据表", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("model:tableConfig:list")
	@ResponseBody
	public Object list(Tablepar tablepar, HttpServletRequest request){
		String jobType = request.getParameter("jobType");
		PageInfo<TableConfig> page=tableConfigService.list(tablepar,jobType);
		TableSplitResult<TableConfig> result=new TableSplitResult<TableConfig>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
		modelMap.put("TableConfig", new TableConfig());
        return prefix + "/edit";
    }
	
	
	@PostMapping("add")
	@RequiresPermissions("model:tableConfig:add")
	@ResponseBody
	public AjaxResult add(TableConfig tableConfig,Model model){
		int b=tableConfigService.insertSelective(tableConfig);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	@PostMapping("remove")
	@RequiresPermissions("model:tableConfig:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=tableConfigService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查用户
	 * @param tableConfig
	 * @return
	 */
	@PostMapping("checkNameUnique")
	@ResponseBody
	public int checkNameUnique(TableConfig tableConfig){
		int b=tableConfigService.checkNameUnique(tableConfig);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("TableConfig", tableConfigService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("model:tableConfig:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TableConfig record)
    {
		int b=0;
    	if(record.getId() ==  null) {
			b = tableConfigService.insertSelective(record);
		}else {
			ConvertUtils.register(new DateConverter(null), java.util.Date.class);
			ConvertUtils.register(new IntegerConverter(null), Integer.class);
			ConvertUtils.register(new LongConverter(null), Long.class);
			ConvertUtils.register(new DoubleConverter(null), Double.class);
			ConvertUtils.register(new StringConverter(null), String.class);
			TableConfig config = new TableConfig();

			try {
				org.apache.commons.beanutils.BeanUtils.copyProperties(config, record);
			} catch (Exception e) {
				return error(e.getMessage());
			}
			TableConfigExample example = new TableConfigExample();
			example.createCriteria().andIdEqualTo(record.getId());
			b = tableConfigService.updateByExample(config,example);

		}
		if(b>0){
			return success();
		}else{
			return error();
		}
    }


    /**
     * 批量启动禁用操作
     */
    @RequiresPermissions("model:tableConfig:edit")
    @PostMapping("/batOperator/{operation}")
    @ResponseBody
    public AjaxResult batOperator(@PathVariable("operation") String operation,@RequestParam("ids") String ids)
    {
        return toAjax(tableConfigService.batchOperator(operation,ids));
    }

    @RequiresPermissions("model:tableConfig:edit")
    @PostMapping("/exec")
    @ResponseBody
    public AjaxResult exec(@RequestParam("id") String id)
    {
        try{
            tableConfigService.execCompare(Integer.parseInt(id));
        }catch (Exception e) {
            return error(e.getMessage());
        }
        return success();
    }

}
