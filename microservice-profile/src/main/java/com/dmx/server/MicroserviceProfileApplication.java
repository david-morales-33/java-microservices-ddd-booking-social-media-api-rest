package com.dmx.server;

import com.dmx.profile.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableDiscoveryClient
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
		value = "com.dmx"
)
public class MicroserviceProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProfileApplication.class, args);
	}

}
