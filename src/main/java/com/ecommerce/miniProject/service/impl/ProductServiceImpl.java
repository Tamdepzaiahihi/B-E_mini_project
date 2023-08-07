package com.ecommerce.miniProject.service.impl;

import com.ecommerce.miniProject.dto.ProductDto;
import com.ecommerce.miniProject.entity.Product;
import com.ecommerce.miniProject.exception.ResourceNotFoundException;
import com.ecommerce.miniProject.mapper.ProductMapper;
import com.ecommerce.miniProject.repository.ProductRepository;
import com.ecommerce.miniProject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public ProductDto createdProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not exist with given id: " + productId));
        return ProductMapper.mapToProductDto(product);
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updateProduct) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not exist with given id: " + productId));

        product.setCategory(updateProduct.getCategory());
        product.setTitle(updateProduct.getTitle());
        product.setActive(updateProduct.getActive());
        product.setDescription(updateProduct.getDescription());
        product.setImage(updateProduct.getImage());
        product.setPrice(updateProduct.getPrice());

        Product updateProductObj = productRepository.save(product);

        return ProductMapper.mapToProductDto(updateProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not exist with given id: " + productId));

        productRepository.deleteById(productId);
    }
}
