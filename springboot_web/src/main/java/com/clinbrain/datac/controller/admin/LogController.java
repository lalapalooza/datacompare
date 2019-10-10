package com.clinbrain.datac.controller.admin;


import io.swagger.annotations.Api;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.auto.TsysOperLog;
import com.clinbrain.datac.model.custom.TableSplitResult;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.model.custom.TitleVo;
import com.github.pagehelper.PageInfo;

/**
 * 日志记录controller
 * @author fuce 
 * @date: 2018年9月30日 下午9:28:31
 */
@Controller
@Api(value = "日志记录")
@RequestMapping("LogController")
public class LogController extends BaseController{

	//跳转页面参数
	private String prefix = "admin/log";
	
	@GetMapping("view")
	@RequiresPermissions("system:log:view")
    public String view(Model model)
    {	
		String str="操作日志";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
		
        return prefix + "/list";
    }
	
	/**
	 * 文件列表
	 * @param tablepar
	 * @param searchTxt 搜索字符
	 * @return
	 */
	@PostMapping("list")
	@RequiresPermissions("system:log:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<TsysOperLog> page=sysOperLogService.list(tablepar,searchTxt) ; 
		TableSplitResult<TsysOperLog> result=new TableSplitResult<TsysOperLog>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

	
	/**
	 * 删除日志
	 * @param ids
	 * @return
	 */
	@PostMapping("remove")
	@RequiresPermissions("system:log:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=sysOperLogService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	

    
    
}
