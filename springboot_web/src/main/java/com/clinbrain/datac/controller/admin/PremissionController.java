package com.clinbrain.datac.controller.admin;

import io.swagger.annotations.Api;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.auto.TsysPremission;
import com.clinbrain.datac.model.custom.TableSplitResult;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.model.custom.TitleVo;
import com.github.pagehelper.PageInfo;

/**
 * 权限Controller
 * @author fuce 
 * @date: 2018年9月2日 下午8:08:21
 */
@Controller
@Api(value = "权限")
@RequestMapping("PremissionController")
public class PremissionController  extends BaseController{
	

	
	//跳转页面参数
	private String prefix = "admin/premission";
	
	@GetMapping("view")
	@RequiresPermissions("system:premission:view")
    public String view(Model model)
    {	
		String str="权限";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 权限列表
	 * @param tablepar
	 * @param searchTxt 搜索字符
	 * @return
	 */
	@PostMapping("list")
	@RequiresPermissions("system:premission:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<TsysPremission> page=sysPremissionService.list(tablepar,searchTxt) ; 
		TableSplitResult<TsysPremission> result=new TableSplitResult<TsysPremission>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	/**
	 * 权限列表
	 * @param tablepar
	 * @param searchTxt 搜索字符
	 * @return
	 */
	@PostMapping("list2")
	@ResponseBody
	public Object list2(Tablepar tablepar,String searchTxt){
		List<TsysPremission> page=sysPremissionService.list2(searchTxt) ; 
		return  page;
	}
	/**
     * 新增权限
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
	
	
    /**
     * 权限添加
     * @param role
     * @return
     */
	@PostMapping("add")
	@RequiresPermissions("system:premission:add")
	@ResponseBody
	public AjaxResult add(TsysPremission role){
		int b=sysPremissionService.insertSelective(role);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除权限
	 * @param ids
	 * @return
	 */
	@PostMapping("remove")
	@RequiresPermissions("system:premission:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=sysPremissionService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查权限
	 * @param TsysPremission
	 * @return
	 */
	@PostMapping("checkNameUnique")
	@ResponseBody
	public int checkNameUnique(TsysPremission TsysPremission){
		int b=sysPremissionService.checkNameUnique(TsysPremission);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 检查权限URL
	 * @param tsysUser
	 * @return
	 */
	@PostMapping("checkURLUnique")
	@ResponseBody
	public int checkURLUnique(TsysPremission tsysPremission){
		int b=sysPremissionService.checkURLUnique(tsysPremission);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 检查权限perms字段
	 * @param tsysUser
	 * @return
	 */
	@PostMapping("checkPermsUnique")
	@ResponseBody
	public int checkPermsUnique(TsysPremission tsysPremission){
		int b=sysPremissionService.checkPermsUnique(tsysPremission);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 修改权限
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/edit/{roleId}")
    public String edit(@PathVariable("roleId") String id, ModelMap mmap)
    {	
		//获取自己的权限信息
		TsysPremission mytsysPremission=sysPremissionService.selectByPrimaryKey(id);
		//获取父权限信息
		TsysPremission pattsysPremission=sysPremissionService.selectByPrimaryKey(mytsysPremission.getPid());
        mmap.put("TsysPremission", mytsysPremission);
        mmap.put("pattsysPremission", pattsysPremission);
        return prefix + "/edit";
    }
	
	/**
     * 修改保存权限
     */
    @RequiresPermissions("system:premission:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TsysPremission TsysPremission)
    {
        return toAjax(sysPremissionService.updateByPrimaryKey(TsysPremission));
    }
    
    /**
     * 获取所有的转换成bootstarp的权限数据
     * @return
     */
    @GetMapping("/getTreePerm")
    @ResponseBody
    public AjaxResult getbooBootstrapTreePerm(){
    	
    	return retobject(200,sysPremissionService.getbooBootstrapTreePerm(null));
    }
    
    
    /**
     * 根据角色id获取bootstarp 所有打勾权限
     * @param roleId 角色id集合
     * @return
     */
    @PostMapping("/getCheckPrem")
    @ResponseBody
    public AjaxResult getCheckPrem(String roleId){
    	
    	return retobject(200,sysPremissionService.getCheckPrem(roleId));
    }
    
    
    /**
     * 跳转到菜单树页面
     * @return
     */
    @GetMapping("tree")
    public String Tree(){
    	 return prefix + "/tree";
    }
    
    /**
     * 获取菜单树
     * @param pid 父id【没用到】
     * @return
     */
    @PostMapping("tree/{pid}")
    @ResponseBody
    public AjaxResult Tree(@PathVariable("pid") String pid){
    	return retobject(200,sysPremissionService.getbooBootstrapTreePerm(null));
    }
    
    
}
