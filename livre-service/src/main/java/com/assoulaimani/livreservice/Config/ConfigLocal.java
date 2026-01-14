package com.assoulaimani.livreservice.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "livre-params")
public class ConfigLocal {
    int c1;
    int c2;

}