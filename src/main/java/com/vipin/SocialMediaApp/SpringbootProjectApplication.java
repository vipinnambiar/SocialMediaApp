package com.vipin.SocialMediaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
	    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = com.vipin.SocialMediaApp.config.KafkaConsumerConfig.class),
	    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = com.vipin.SocialMediaApp.config.KafkaProducerConfig.class),
	    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = com.vipin.SocialMediaApp.service.KafkaConsumerService.class),
	    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = com.vipin.SocialMediaApp.service.KafkaProducerService.class),
	    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = com.vipin.SocialMediaApp.controller.KafkaController.class)
	})
public class SpringbootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}

}
