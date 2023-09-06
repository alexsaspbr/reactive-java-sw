package br.com.ada.reactivejavasw.service;

import br.com.ada.reactivejavasw.converter.ProductConverter;
import br.com.ada.reactivejavasw.dto.ProductDTO;
import br.com.ada.reactivejavasw.dto.ResponseDTO;
import br.com.ada.reactivejavasw.model.Product;
import br.com.ada.reactivejavasw.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ProductService {

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductRepository productRepository;


    public Mono<ResponseDTO<ProductDTO>> create(ProductDTO productDTO) {

        //converter dto em model
        Product product = this.productConverter.toProduct(productDTO);
        //salvar na base de dados o model
        Mono<Product> productMono = this.productRepository.save(product);
        //retornar o dado salvo como dto
        return productMono
                .map((productDocument) -> new ResponseDTO("Produto cadastrado com sucesso!",
                        this.productConverter.toProductDTO(productDocument),
                        LocalDateTime.now()));


    }

}
