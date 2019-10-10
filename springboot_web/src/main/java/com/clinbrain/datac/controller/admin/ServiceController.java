package com.clinbrain.datac.controller.admin;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.model.custom.Service;
import com.clinbrain.datac.model.custom.TitleVo;

import io.swagger.annotations.Api;

/**
 * 服务器信息Controller
 * @ClassName: ServiceController
 * @author fuce
 * @date 2019-06-23 00:55
 * @version V1.0
 */
@Controller
@Api(value = "服务器信息")
@RequestMapping("ServiceController")
public class ServiceController extends BaseController{

	//跳转页面参数
	private String prefix = "admin/service";
	
	@GetMapping("view")
	@RequiresPermissions("system:service:view")
    public String view(Model model)
    {	
		
		String str="服务器";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
		
		model.addAttribute("service", new Service());
		
        return prefix + "/list";
    }
}
