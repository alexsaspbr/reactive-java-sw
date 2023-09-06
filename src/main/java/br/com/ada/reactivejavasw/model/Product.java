package br.com.ada.reactivejavasw.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "products")
public class Product {

    //@Document -> @Entity
    //Collections -> Tabela
    //Documents (Dados) -> Registros

    @Id
    private String id = new ObjectId().toString();
    private String name;
    private String description;
    private BigDecimal amount;

    public Product(String name, String description, BigDecimal amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

}
