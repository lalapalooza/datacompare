package com.clinbrain.datac.controller;

import com.clinbrain.datac.model.custom.EtlHistablePartitionsConfiguration;
import com.clinbrain.datac.service.ConnectionService;
import com.clinbrain.datac.common.base.BaseController;
import com.clinbrain.datac.common.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/connection")
public class ConnectionController extends BaseController {
    @Autowired
    private ConnectionService connectionService;
    @GetMapping("sync")
    @ResponseBody
    public AjaxResult sync() throws Exception {
        if(connectionService.insertConnectionByEtl() > 0) {
            return success();
        }
        return error();
    }
    @GetMapping("getHisPartConf")
    @ResponseBody
    public List<EtlHistablePartitionsConfiguration> getHisPartConf() throws Exception {
        return connectionService.getHisPartConf();
    }

}
