package com.ecommerce.miniProject.service;
import com.ecommerce.miniProject.dto.ProductDto;
import com.ecommerce.miniProject.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto createdProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct (Long productId, ProductDto updateProduct);
    void deleteProduct (Long productId);
}
