package org.example.server.common.api.impl;

import org.example.server.common.util.ApiUtil;
import org.example.server.common.util.DateTimeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;


@RestController
@RequestMapping("")
public class IndexImplApiCommon {
    @RequestMapping("")
    public ApiUtil helloWorld() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>() {{
            put("out", "Hello World!");
            put("timestamp", DateTimeUtil.formatValue(new Date().getTime()));
        }};
        return ApiUtil.normal(data, "success", 200);
    }

}
