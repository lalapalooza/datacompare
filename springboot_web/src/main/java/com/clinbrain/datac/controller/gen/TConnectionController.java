package com.clinbrain.datac.controller.gen;

import com.clinbrain.datac.model.auto.TConnection;
import com.clinbrain.datac.service.ConnectionService;
import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.custom.TitleVo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("TConnectionController")
@Api(value = "数据库连接信息")
public class TConnectionController extends BaseController{
	
	private String prefix = "admin/tConnection";
	@Autowired
	private ConnectionService tConnectionService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:tConnection:view")
    public String view(Model model)
    {	
		String str="数据库连接信息";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }

	
	/**
     * 新增
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
	
	@PostMapping("add")
	@RequiresPermissions("gen:tConnection:add")
	@ResponseBody
	public AjaxResult add(TConnection tConnection, Model model){
		int b=tConnectionService.insertSelective(tConnection);
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
	@RequiresPermissions("gen:tConnection:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=tConnectionService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
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
        mmap.put("TConnection", tConnectionService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:tConnection:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TConnection record)
    {
        return toAjax(tConnectionService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
