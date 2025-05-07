package com.kanishki.SpringEcomm.controller;

import com.kanishki.SpringEcomm.model.Product;
import com.kanishki.SpringEcomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/products", produces = {"application/json"})
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductID(@PathVariable("productId") int productId){

        Product product = productService.getProductById(productId);

        if(product != null){
            return new ResponseEntity<>(product.getImage(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId){

        Product product = productService.getProductById(productId);

        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){

        Product savedProduct = null;

        try {
            savedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int productId, @RequestPart Product product, @RequestPart MultipartFile imageFile){

        Product updatedProduct = null;

        try{
            productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>("Product Updated", HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int productId){

        Product product = productService.getProductById(productId);

        if(product != null){
            productService.deleteProduct(productId);
            return new ResponseEntity<>("Deleted a product", HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){

        List<Product> products = productService.searchProducts(keyword);
        System.out.println("Searching with " + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
