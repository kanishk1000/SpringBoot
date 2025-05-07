package com.kanishki.SpringEcomm.service;

import com.kanishki.SpringEcomm.model.Product;
import com.kanishki.SpringEcomm.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

        product.setImageName(image.getName());
        product.setImageType(image.getContentType());
        product.setImage(image.getBytes());

        return productRepo.save(product);
    }


    public void deleteProduct(int productId) {

        productRepo.deleteById(productId);
    }

    public List<Product> searchProducts(String keyword) {

        return productRepo.searchProducts(keyword);
    }
}
