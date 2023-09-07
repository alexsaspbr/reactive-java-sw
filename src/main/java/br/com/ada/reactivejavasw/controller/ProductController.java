package br.com.ada.reactivejavasw.controller;

import br.com.ada.reactivejavasw.service.ProductService;
import br.com.ada.reactivejavasw.dto.ProductDTO;
import br.com.ada.reactivejavasw.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Create a product",
               requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    public Mono<ResponseDTO> create(@RequestBody ProductDTO productDTO) {
        return this.productService.create(productDTO);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Find all products")
    public Flux<ResponseDTO<ProductDTO>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("{code}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Find by code of product")
    public Mono<ResponseDTO<ProductDTO>> findByCode(@PathVariable("code") String code) {
        return this.productService.findByCode(code);
    }

}
