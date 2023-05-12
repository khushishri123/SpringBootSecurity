package com.example.SpringbootSecurityDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringbootSecurityDemoApplication {

//	@Autowired
//	UserRepository userRepository;
//	//now we want that initUsers should get execute at the time of application startup, we have annotate this method with @PostConstruct
//	@PostConstruct
//	public void initUsers()
//	{
//		List<User> users= Stream.of(
//				new User(101,"Raj","Raj"),
//				new User(102,"Shivani","Shivani"),
//				new User(103,"Garima","Garima")
//		).collect(Collectors.toList());
//		userRepository.saveAll(users);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityDemoApplication.class, args);
		System.out.println("Hello");
	}

}
