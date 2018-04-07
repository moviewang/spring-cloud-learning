package com.cloud.client.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Movie on 2018/4/7.
 */
@ConfigurationProperties(prefix = "info")
@RefreshScope
@Configuration
public class TestConfiguration {
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
