package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.dao.ProduitRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.CategorieService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;


@SpringBootTest
@Disabled
class CategorieServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProduitRepository produitRepository;


    @InjectMocks
    private CategorieServiceImpl categorieService;

    @Test
    void findByIdcatTest() {
    }

    @Test
    void addCategoryTest() throws NullException {
        //Given
        Categorie categorie= new Categorie("teste","teste");
        when(categoryRepository.save(categorie)).thenReturn(categorie);

        //when
        Categorie categorieSave= categorieService.addCategory(categorie);

        //Then
        assertAll( () -> assertNotNull(categorieSave),
                   () -> assertEquals("teste", categorieSave.getNomCat()),
                   () -> assertNotEquals("teste", categorieSave.getIdCat()));

    }

    @Test
    void isExistCatTest() {
    }

    @Test
    void updateCatTest() {
    }


    @Test
    void deleteCatTest() throws RessourseNotFounfException {
        //given
        String idCat = "1";
        Optional<Categorie> categorie = Optional.of(new Categorie("1", "nomCategorie"));

        when(categoryRepository.findById(idCat)).thenReturn(categorie); // simule categoryRepository.findById(idCat) a cette categorie precedente
        doNothing().when(categoryRepository).delete(isA(Categorie.class));//

        // when
        Categorie result = categorieService.deleteCat(idCat);

        // then
        verify(categoryRepository, times(1)).delete(categorie.get());
        assertAll( () -> assertNotNull(result),
                   () -> assertEquals("1", result.getIdCat()),
                   () -> assertEquals("nomCategorie", result.getNomCat()));
    }

    @Test
    void deleteCatTestWithException() {
        //given
       /* String idCat = "1";
        Optional<Categorie> categorie = Optional.of(new Categorie("1", "nomCategorie"));*/

       /* when(categoryRepository.findById(anyString())).thenReturn(null); // simule categoryRepository.findById(idCat) a cette categorie precedente
        doNothing().when(categoryRepository).delete(isA(Categorie.class));//


        // then
        //verify(categoryRepository, times(1)).delete(categorie.get());
        assertThrows(RessourseNotFounfException.class,
                ()->{
                  categoryRepository.findById("idCat");
                }
                );*/
    }


    @Test
    void findAllTest() {
        when(categoryRepository.findAll())
                .thenReturn(Stream.of(new Categorie(null,"te1"),new Categorie(null,"t2")).collect(Collectors.toList()));
        assertEquals(2, categorieService.findAll().size());
    }



    @Test
    void testFindAllWithKeyword() {
        // Given
        String key ="teste";
        when(categoryRepository.findAll(key))
                .thenReturn(Stream.of(new Categorie(null,"teste"),new Categorie(null,"t2teste")).collect(Collectors.toList()));

        //When
        List<Categorie> categorieList= categorieService.findAll(key);

        //Then
        assertAll(
                () -> assertNotNull(categorieList),
                () -> assertEquals(2, categorieList.size()),
                () -> assertEquals("teste", categorieList.get(0).getNomCat()),
                () -> assertNotEquals("teste", categorieList.get(1).getNomCat()));
    }

    @Test
    void addProductToCategorieTest() {
    }

    @Test
    void deleteProductToCategorieTest() {
    }

    @Test
    void testDeleteProductToCategorieTest() {

    }

    @Test
    void getProductByCategorieTest() throws RessourseNotFounfException {
       /* //given
        String idCat = "1";
        Optional<Categorie> categorie = Optional.of(new Categorie("1", "nomCategorie"));
        Produit produit1=Produit.builder().nomPdt("testPdt").prixAchatPdt(12345).categorie(categorie.get()).build();
        Produit produit2=Produit.builder().nomPdt("testPdt2").prixAchatPdt(45600).categorie(categorie.get()).build();
        Produit produit3=Produit.builder().nomPdt("testPdt3").prixAchatPdt(3000).categorie(categorie.get()).build();
        Produit produit4=Produit.builder().nomPdt("testPdt4").prixAchatPdt(6000).categorie(categorie.get()).build();
        Collection<Produit> produits= new ArrayList<>();
        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);
        produits.add(produit4);
        when(categoryRepository.findById(idCat)).thenReturn(categorie);
        when(produitRepository.save(produit1)).thenReturn(produit1);
        when(produitRepository.save(produit2)).thenReturn(produit2);
        when(produitRepository.save(produit3)).thenReturn(produit3);
        when(produitRepository.save(produit4)).thenReturn(produit4);
        when(produitRepository.findByCategorie(categorie.get())).thenReturn((List<Produit>) produits);

        //When
        Collection<Produit> produits1= categorieService.getProductByCategorie(idCat);
        //Then
        assertAll(
                () -> assertNotNull(produits1),
                () -> assertEquals(4, produits1.size()));*/
    }


}