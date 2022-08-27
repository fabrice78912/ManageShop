package com.example.managershop;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ManagerShopApplicationTests {

	@Test
	void contextLoads() {
	}



}
