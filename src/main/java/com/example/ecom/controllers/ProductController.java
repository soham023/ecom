package com.example.ecom.controllers;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;
import com.example.ecom.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

// in case of controllers you just only dont want to create objects of these controllers.
// You want this controllers to be capable of accepting a network request and responding with a correct response.

// every @RestController --> @Controller (Semantic Purpose)
// Apart from Controller 1 more thing that restController has its @ResponseBody
@RestController

@RequestMapping("/api/products")

public class ProductController {

//    @Qualifier("productService") // does not work at field level has to be at constructor level
    private IProductService productService;

    // Constructor Based Injection
    ProductController(@Qualifier("productService")IProductService _productService){
        this.productService = _productService;
    }

    @GetMapping ("/title")
    public ResponseEntity<List<ProductTitleDTO>> getAllProducts() throws IOException {
        List<ProductTitleDTO> response = this.productService.getAllProducts();
//        return ResponseEntity
//                .created(null)
//                .body(response);
            return ResponseEntity.ok(response);
            /*
            * Response Entity gives more control in your response by having control in your response code / Http Status Code
            * */
    }

    @GetMapping("/productById/{id}")
    /* with PathVariable the parameter that you are passing into your function (here it is id), It gets
    wired up with the parameter that is coming from your routes.
     */
    public ResponseEntity<ProductDTO>  getProductById (@PathVariable Long id) throws Exception {
        ProductDTO res = this.productService.getProductById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws Exception {
        ProductDTO productDTONew =  this.productService.createProduct(productDTO);
        return ResponseEntity.ok(productDTONew);
    }


    @GetMapping("/{id}/detailsOfCategory")
    public ResponseEntity<ProductWithCategoryDTO> getProductsWithCategory(@PathVariable long id) throws Exception{
        ProductWithCategoryDTO dto = productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/count")
    public int getCategoryCount(){
        return 5;
    }
}
