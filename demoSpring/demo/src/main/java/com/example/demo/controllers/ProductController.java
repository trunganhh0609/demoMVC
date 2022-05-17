package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.models.ResponseObject;
import com.example.demo.repos.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Products")
public class ProductController {

    @Autowired
    private ProductRepos productRepos;

    @GetMapping("/getAllProducts")
    //http:localhost:8080/api/v1/Products/getAllProducts
    List<Product> getAllProducts(){
        return productRepos.findAll();
    }


    @GetMapping("/FindById/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Product> product = productRepos.findById(id);
        if(product.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Successfully",product)
            );
            }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("error","Error: Can't find Product with id :"+id, "")
                );
            }
        }

    //insert
    @PostMapping("/insertProduct")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        List<Product> foundProduct = productRepos.findByProductName(newProduct.getProductName().trim());
        if(foundProduct.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("fail","Product name already taken", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Insert successfully", productRepos.save(newProduct)));
    }
    //update & insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> update(@RequestBody Product newProduct, @PathVariable Long id){
        Product updateProduct =  productRepos.findById(id).map(product -> {product.setProductName(newProduct.getProductName());
                                                                            product.setYear(newProduct.getYear());
                                                                            product.setPrice(newProduct.getPrice());
                                                                            product.setUrlImage(newProduct.getUrlImage());
        return productRepos.save(product);}).orElseGet(() ->{newProduct.setId(id);
                    return productRepos.save(newProduct);});

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update successfully", updateProduct));
    }

}