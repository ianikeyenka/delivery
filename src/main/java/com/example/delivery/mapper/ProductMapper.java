package com.example.delivery.mapper;

import com.example.delivery.dto.ProductDTO;
import com.example.delivery.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO productToProductDto(ProductModel productModel);

    ProductModel productDtoToProduct(ProductDTO productDTO);
}
