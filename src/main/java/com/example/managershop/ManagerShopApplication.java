package com.example.managershop;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.AccountService;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
//@EnableJpaRepositories(basePackageClasses = {CategorieService.class , CategoryRepository.class})
//@EnableSwagger2
public class ManagerShopApplication /*extends SpringBootServletInitializer*///implements CommandLineRunner
{
     private static final Logger LOGGER= LoggerFactory.getLogger(ManagerShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ManagerShopApplication.class, args);
		LOGGER.info(" Application Started  !!!!! You can use it !!");
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ManagerShopApplication.class);
	}*/


	@Bean
	public BCryptPasswordEncoder getBCPE(){  // crypte les mdp
		return  new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper mapper(){
		return  new ModelMapper();
	}
}
