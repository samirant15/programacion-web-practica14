package com.juandiii.practica13;

//import com.hazelcast.cache.HazelcastCacheManager;
//import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@SpringBootApplication
public class Practica13Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica13Application.class, args);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("juandiegolopezve@gmail.com");
		mailSender.setPassword("");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}


//	@Bean
//	HazelcastInstance hazelcastInstance() {
//		ClientConfig config = new ClientConfig();
//		config.getGroupConfig().setName("dev").setPassword("dev-pass");
//		config.getNetworkConfig().addAddress("192.168.99.100");
//		config.setInstanceName("cache-1");
//		HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);
//		return instance;
//	}
//
//	@Bean
//	CacheManager cacheManager() {
//		return new HazelcastCacheManager(hazelcastInstance());
//	}

}
