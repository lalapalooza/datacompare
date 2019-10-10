package com.clinbrain.datac.common.exception;

import com.clinbrain.datac.common.base.BaseController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Liaopan on 2019/9/2.
 */
public class MyErrorController extends BaseController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public Object errorPath() throws Exception {
        throw new Exception("找不到请求信息");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
