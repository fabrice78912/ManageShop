
package com.example.managershop.dto;

import com.example.managershop.entities.Produit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategorieDto {

    @JsonIgnore
    private Long idCat;
    // @NotBlank(message = "Name is mandatory")
    //@Column(length=50)
    //@Size(max = 30 , min = 8)
    //@NotNull
    private String nomCat;
    private Boolean archived=false;
    @JsonIgnore
    private Collection<Produit> produits= new ArrayList<>();

}
