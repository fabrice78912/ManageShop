package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.dao.ProduitRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.CategorieService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
//@Component
//@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CategorieServiceImpl.class);

    @Autowired
    private CategorieService categorieService ;
    @Autowired
    private CategoryRepository categoryRepository ;
    @Autowired
    private ProduitRepository produitRepository;

   /* public CategorieServiceImpl(CategorieService categorieService, CategoryRepository categoryRepository) {
        this.categorieService = categorieService;
        this.categoryRepository = categoryRepository;
    }*/

    @Override
    public Categorie findByIdcat(String idcat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idcat).isPresent()) {
            throw new RessourseNotFounfException("Categorie with id :"+idcat+ "not found");
        }
        return categoryRepository.findById(idcat).get();
    }

    @Override
    public Categorie addCategory(Categorie c) throws NullException {
        c.setIdCat(UUID.randomUUID().toString());
        return categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(String idcat) {
        return categoryRepository.findById(idcat).isPresent();
    }

    @Override
    public Categorie updateCat(String idCat, Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException {
        if (!isExistCat(idCat)) throw new RessourseNotFounfException("Categorie with id ID :"+idCat+" not found");
        findByIdcat(idCat).setNomCat(newCat.getNomCat());
        findByIdcat(idCat).setArchived(newCat.getArchived());
        return categoryRepository.save(findByIdcat(idCat));
    }

    @Override
    public Categorie deleteCat(String idCat) throws RessourseNotFounfException {
        if(!isExistCat(idCat)) throw new RessourseNotFounfException("Categorie with id ID :"+idCat+" not found");
        Categorie cate = categoryRepository.findById(idCat).get();
        categoryRepository.delete(cate);
        return cate;
    }

    @Override
    public List<Categorie> findAll(String keyword) {
        return categoryRepository.findAll(keyword);
    }

    @Override
    public List<Categorie> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Categorie> findAllSort() {
        //Categorie categorie= new Categorie();
        return categoryRepository.findAll(Sort.by("nomCat","idCat").ascending());
    }

    @Override
    public Categorie addProductToCategorie(String idPdt, String idCat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) throw  new RessourseNotFounfException("category with id :"+idCat+" not found");
        if(!produitRepository.findById(idPdt).isPresent()) throw new RessourseNotFounfException("Product with id :"+idPdt+" not found");
        Categorie categorie=categoryRepository.findById(idCat).get();
        Produit produit=produitRepository.findById(idPdt).get();
        categorie.getProduits().add(produit);
        categoryRepository.save(categorie);
        return categorie;
    }

    @Override
    public Categorie deleteProductToCategorie(Long idPdt, String idCat) {

        return null;
    }

    @Override
    public Categorie deleteProductToCategorie(List<Produit> produits, String idCat) {
        return null;
    }

    @Override
    public Collection<Produit> getProductByCategorie(String idCat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) throw new RessourseNotFounfException("Categorie with Id :"+idCat+" not found");
        return categoryRepository.findById(idCat).get().getProduits();
    }

    @Override
    public Page<Categorie> listePaginedCategorie(int page, int size, String sortfield, String SortDirection) {
        Sort sort = SortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortfield).ascending() : Sort.by(sortfield).descending();
        Pageable pageable= PageRequest.of(page - 1 , size, sort);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Categorie> getCatByNameIgnoreCase(String nameCat) throws RessourseNotFounfException {
        if (ObjectUtils.isEmpty(categoryRepository.findByNomCatIgnoreCase(nameCat))) throw new RessourseNotFounfException("Liste vide");
        return categoryRepository.findByNomCatIgnoreCase(nameCat);
    }

    @Override
    public List<Categorie> getCatByNameContaining(String nameCat) throws RessourseNotFounfException {
        if (ObjectUtils.isEmpty(categoryRepository.findByNomCatContaining(nameCat))) throw new RessourseNotFounfException("Liste vide");
        return categoryRepository.findByNomCatContaining(nameCat);
    }



   /* @Override
    public Categorie findByIdcat(Long idcat) {
        if(ObjectUtils.nullSafeEquals(categoryRepository.findByIdCat(idcat),null)) return null;
        return categoryRepository.findById(idcat).get();
    }*/

    /*@Override
    public Categorie findByIdcat(String idcat) throws RessourseNotFounfException {
        if(ObjectUtils.nullSafeEquals(categoryRepository.findById(idcat),null)) throw  new RessourseNotFounfException("Categorie with id :"+idcat+" Not found");
        return categoryRepository.findById(idcat).get();
        //categoryRepository.fi
    }


    @Override
    public Categorie addCategory(Categorie c) throws NullException {
        //if(ObjectUtils.nullSafeEquals(c, null)) throw new NullException("Categorie is empty");
        if(c.getNomCat().equals(null)) {throw new NullException("Categorie should be not empty");}
        return this.categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(String idCat) {
        return false;
    }

    @Override
    public Categorie updateCat(String idCat, Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException {
        return null;
    }

    @Override
    public Categorie deleteCat(String idCat) throws CategorieNotFoundException, RessourseNotFounfException {
        return null;
    }

    @Override
    public boolean isExistCat(Long idCat) {
        return categoryRepository.existsById(idCat);
    }

    @Override
    public Categorie updateCat(Long idCat, Categorie newCat) throws RessourseNotFounfException {
        if(ObjectUtils.nullSafeEquals(findByIdcat(idCat),null)) return null;
        if(ObjectUtils.nullSafeEquals(newCat,null)){
            return categoryRepository.findById(idCat).get();
        }
        findByIdcat(idCat).setNomCat(newCat.getNomCat());
        findByIdcat(idCat).setArchived(newCat.getArchived());
        return categoryRepository.save(findByIdcat(idCat));

    }

    @Override
    public Categorie deleteCat(Long idCat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) return null;
        Categorie cate = categoryRepository.findById(idCat).get();
        categoryRepository.delete(findByIdcat(idCat));
        return cate;
    }


    @Override
    public List<Categorie> findAll(String keyword) {
        if(keyword!=""){
            return categoryRepository.findAll(keyword);
        }
        return categoryRepository.findAll();
    }

    @Override
    public List<Categorie> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Categorie searchCatById(String id) {
        return null;
    }


    @Override
    public Categorie searchCatById(Long id) {
        return categoryRepository.findByIdCat(id);
    }

    @Override
    public Categorie searchCatById1(String id) {
        if(categoryRepository.findById(id).isPresent())
           return categoryRepository.findById(id).get();
        else return null;
    }
*/

}
