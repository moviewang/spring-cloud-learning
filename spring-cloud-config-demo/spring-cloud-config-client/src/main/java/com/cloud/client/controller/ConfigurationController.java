package com.cloud.client.controller;

import com.cloud.client.constants.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Movie on 2018/4/8.
 */
@RestController
@RequestMapping("info")
@RefreshScope
public class ConfigurationController {
    @Autowired
    private TestConfiguration testConfiguration;

    public String info() {
        return testConfiguration.getFrom();
    }
}
