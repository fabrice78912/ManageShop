package com.example.managershop.config;

import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class RunnerConfig {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private RoleService roleService;

    @Bean
    CommandLineRunner start(){
        return  args -> {

            Stream.of("Test","resussite","God","Allelluya","Jesus","MontReal","resussite").forEach(c->{
                try {
                    categorieService.addCategory(Categorie.builder().nomCat(c).archived(false).build());
                } catch (NullException e) {
                    e.printStackTrace();
                }
            });

            categorieService.findAll().forEach(cat->{
                System.out.println(cat.getNomCat());

                //System.out.println(mapEntityToDto.CategorieToCategorieDTO(new Categorie("test")).toString());
            });

        };
    }
}
