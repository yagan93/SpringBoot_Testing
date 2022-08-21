package com.example.testing.domain.product.dto;

import com.example.testing.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product fromDTO(ProductDTO productDTO);

    List<Product> fromDTOs(List<ProductDTO> productDTOS);

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOs(List<Product> products);
}
