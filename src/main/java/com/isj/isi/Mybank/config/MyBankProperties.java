package com.isj.isi.Mybank.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mybank-properties")
@Data

public class MyBankProperties {
    private String backendHost;
}

