package com.ecommerce.miniProject.mapper;

import com.ecommerce.miniProject.dto.ProductDto;
import com.ecommerce.miniProject.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getCategory(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getActive(),
                product.getImage()

        );
    }
    public static Product mapToProduct(ProductDto productDto){
        return  new Product(
                productDto.getId(),
                productDto.getCategory(),
                productDto.getTitle(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getActive(),
                productDto.getImage()

        );
    }
}
