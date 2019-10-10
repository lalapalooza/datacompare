package com.clinbrain.datac.controller.gen;

import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import com.clinbrain.datac.model.auto.TableStatus;
import com.clinbrain.datac.model.custom.TableSplitResult;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.model.custom.TitleVo;
import com.clinbrain.datac.service.TableStatusService;
import com.github.pagehelper.PageInfo;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("TableStatusController")
@Api(value = "VIEW")
public class TableStatusController extends BaseController{
	
	private String prefix = "admin/tableStatus";
	@Autowired
	private TableStatusService tableStatusService;
	
	@GetMapping("view")
	@RequiresPermissions("model:tableStatus:view")
    public String view(Model model)
    {	
		String str="VIEW";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        Map dashboard = tableStatusService.mainDashboard();
        model.addAttribute("main",dashboard);
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("model:tableStatus:list")
	@ResponseBody
	public Object list(Tablepar tablepar, HttpServletRequest request){
	    String where = request.getParameter("where");
		PageInfo<TableStatus> page=tableStatusService.list(tablepar,where) ;
		TableSplitResult<TableStatus> result=new TableSplitResult<TableStatus>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
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
	@RequiresPermissions("model:tableStatus:add")
	@ResponseBody
	public AjaxResult add(TableStatus tableStatus,Model model){
		int b=tableStatusService.insertSelective(tableStatus);
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
	@RequiresPermissions("model:tableStatus:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=tableStatusService.deleteByPrimaryKey(ids);
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
        mmap.put("TableStatus", tableStatusService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("model:tableStatus:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TableStatus record)
    {
        return toAjax(tableStatusService.updateByPrimaryKeySelective(record));
    }

    /**
     * 返回主页的几个看板数据
     * 结构： {"job_type":{"success":12,"total":20,"disable":13}}
     * @return
     */
    public AjaxResult mainDashBoard() {
        // 前端 -》 hive ods
        return AjaxResult.successData(1,tableStatusService.mainDashboard());
    }
	
}
