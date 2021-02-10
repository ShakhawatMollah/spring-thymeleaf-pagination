package com.shakhawat.pagination;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

import com.github.javafaker.Faker;
import com.shakhawat.pagination.domain.entity.Visitor;
import com.shakhawat.pagination.domain.service.VisitorService;

@SpringBootApplication
public class SpringThymeleafPaginationApplication {
	
	@Autowired
	private VisitorService visitorService;

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafPaginationApplication.class, args);
	}
	
	@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
	
	@PostConstruct
	public void initData() {
		List<Visitor> vtr = new ArrayList<Visitor>();
		
		for (int i = 0; i < 2000; i++) {
			Visitor visitor = new Visitor();
			Faker faker = new Faker();
			//Gender
			visitor.setTitle(faker.name().title());
			visitor.setFirstName(faker.name().firstName());
			visitor.setLastName(faker.name().lastName());
			visitor.setMobileNo(faker.phoneNumber().cellPhone());
			visitor.setAddress(faker.address().fullAddress());
			visitor.setEmail(faker.internet().safeEmailAddress());
			visitor.setGender(faker.demographic().sex());
			
			vtr.add(visitor);
		}
		visitorService.saveAllVisitors(vtr);
	}

}
