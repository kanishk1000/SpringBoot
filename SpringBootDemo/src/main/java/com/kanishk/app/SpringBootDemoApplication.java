package com.kanishk.app;

import com.kanishk.app.model.Alien;
import com.kanishk.app.model.Laptop;
import com.kanishk.app.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		LaptopService service = context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);

//		Alien obj = context.getBean(Alien.class);
//		obj.code();
//		System.out.println(obj.getAge());
	}

}
