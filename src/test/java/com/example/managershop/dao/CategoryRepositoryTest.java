package com.example.managershop.dao;

import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@Disabled
class CategoryRepositoryTest {

    @Autowired
    private  CategoryRepository categoryRepository;

    //@Autowired
    //private CategorieService categorieService;

    @Test
    @Disabled
    void findByIdCatTest() {

        String idCate="503c7ff8-d18a-4245-adca-3a37cbc5b2c4";
        Categorie excepted=categoryRepository.findById(idCate).get();
        Assert.assertNotNull(excepted);
    }

    @Test
    void findAllTest() {
        //Given

        String keyword="test";
        //List<Categorie> categorieList= Stream.of(new Categorie(null,"te1"),new Categorie(null,"t2")).collect(Collectors.toList()));

        //when
         List<Categorie> excepted=categoryRepository.findAll(keyword);
        // Then

        Assert.assertNotNull(excepted);
        //Assert.assertEquals(excepted.size(),0);

    }


    @Test
    void findAllWithoutCaractereTest() {
        //Given

        String keyword="";
        //List<Categorie> categorieList= Stream.of(new Categorie(null,"te1"),new Categorie(null,"t2")).collect(Collectors.toList()));

        //when
        List<Categorie> excepted=categoryRepository.findAll();
        // Then

        Assert.assertNotNull(excepted);
        //Assert.assertEquals(excepted.size(),0);


    }
}