package ca.gbc.productservice.service;

import ca.gbc.productservice.dto.ProductRequest;
import ca.gbc.productservice.dto.ProductResponse;
import ca.gbc.productservice.model.Product;
import ca.gbc.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(product ->
                ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build()
        ).toList();
    }

    public void updateProduct(String id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
