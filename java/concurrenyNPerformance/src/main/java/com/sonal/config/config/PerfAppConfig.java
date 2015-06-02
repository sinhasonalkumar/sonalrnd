package com.sonal.config.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@Configurable
@ComponentScan(basePackages={"com.sonal"})
@EnableAsync
public class PerfAppConfig {

}
