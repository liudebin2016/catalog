package com.jusfoun.catalog.controller;

import com.jusfoun.catalog.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 统计Controller
 * @author Connor
 * @version 2015-12-28 18:19:00
 */
@Controller
public class DictController extends BaseController{

    /**
     * 显示字典列表页面
     *
     */
    @RequestMapping(value = "${adminPath}/dict/list", method = RequestMethod.GET)
    public String getDictListPage() {
        return "admin/dict/list";
    }
}
