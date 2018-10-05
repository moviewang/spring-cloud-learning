package com.cloud.client.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by Movie on 2018/4/7.
 */
@ConfigurationProperties(prefix = "info")
@Component
@RefreshScope
public class TestConfiguration {
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
