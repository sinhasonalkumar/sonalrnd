package com.sonal.SpringCloudSleuth;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.sonal")
@EnableAsync
public class SpringCloudSleuthApplication {
    
    private static final Log log = LogFactory.getLog(SpringCloudSleuthApplication.class);

    
    public static void main(String[] args) {
	SpringApplication.run(SpringCloudSleuthApplication.class, args);
    }
    
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*// Use this for debugging (or if there is no Zipkin server running on port 9411)
	@Bean
	@ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
	public ZipkinSpanReporter spanCollector() {
		return new ZipkinSpanReporter() {
			@Override
			public void report(zipkin.Span span) {
				log.info(String.format("Reporting span [%s]", span));
			}
		};
	}*/
}
