package com.envoy.biz.controller;

import com.envoy.biz.annotation.AutoResponse;
import com.envoy.biz.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shizi
 * @since 2022-06-14 20:39:28
 */
@AutoResponse
@RequestMapping("/api/a")
@RestController
public class FrontController {

    @Autowired
    private FrontService frontService;

    @GetMapping("front/adef/{haveRedis}/{haveMysql}")
    public String adef(@PathVariable("haveRedis") Boolean haveRedis, @PathVariable("haveMysql") Boolean haveMysql) {
        return frontService.adef(haveRedis, haveMysql);
    }

    @GetMapping("ba/{haveRedis}/{haveMysql}")
    public String ba(@PathVariable("haveRedis") Boolean haveRedis, @PathVariable("haveMysql") Boolean haveMysql) {
        return frontService.ba(haveRedis, haveMysql);
    }
}
