package com.juandiii.practica13;

//import com.hazelcast.cache.HazelcastCacheManager;
//import com.hazelcast.core.HazelcastInstance;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.Properties;
import java.util.UUID;

@Controller
@SpringBootApplication
public class Practica13Application {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Practica13Application.class, args);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("samirant15@gmail.com");
		mailSender.setPassword("");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

//			User user = new User(UUID.randomUUID().toString(), "a"	, "a");

//			userService.saved(user);
		};
	};


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
