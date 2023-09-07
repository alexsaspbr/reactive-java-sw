package br.com.ada.reactivejavasw.converter;

import br.com.ada.reactivejavasw.dto.ProductDTO;
import br.com.ada.reactivejavasw.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getCode(), product.getName(), product.getDescription(), product.getAmount());
    }

    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getCode(), productDTO.getName(), productDTO.getDescription(), productDTO.getAmount());
    }

}
