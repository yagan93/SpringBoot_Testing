package com.example.testing.domain.product;

import com.example.testing.domain.product.dto.ProductDTO;
import com.example.testing.domain.product.dto.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> retrieveById(@PathVariable UUID id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(productMapper.toDTO(product), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER_READ')")
    public ResponseEntity<List<ProductDTO>> retrieveAll() {
        return new ResponseEntity<>(productMapper.toDTOs(productService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        Product product = productService.save(productMapper.fromDTO(productDTO));
        return new ResponseEntity<>(productMapper.toDTO(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
        Product product = productService.save(productMapper.fromDTO(productDTO));
        return new ResponseEntity<>(productMapper.toDTO(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
