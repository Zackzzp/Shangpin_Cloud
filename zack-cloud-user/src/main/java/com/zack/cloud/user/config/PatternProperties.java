package com.zack.cloud.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {

    private String dateformat ;
    private String envSharedValue;

}
