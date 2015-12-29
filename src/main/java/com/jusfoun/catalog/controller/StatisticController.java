package com.jusfoun.catalog.controller;

import com.jusfoun.catalog.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 统计Controller
 * @author Connor
 * @version 2015-12-28
 */
@Controller
public class StatisticController extends BaseController {


    @RequestMapping(value = "${adminPath}/statistic/search", method = RequestMethod.GET)
    public String getSearchCountPage() {
        return "admin/statistic/search";
    }

    @RequestMapping(value = "${adminPath}/statistic/info", method = RequestMethod.GET)
    public String getInfoCountPage() {
        return "admin/statistic/info";
    }
}
