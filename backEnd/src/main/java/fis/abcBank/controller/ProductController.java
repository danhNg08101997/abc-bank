package fis.abcBank.controller;

import fis.abcBank.constant.APIConstant;
import fis.abcBank.dto.request.ProductRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.ProductResponse;
import fis.abcBank.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConstant.API_PRODUCT)
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.OK).body(productService.createProduct(productRequest));
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productRequest));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> delete(@RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productRequest));
    }
    @PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<ProductResponse>>getAll(@RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct(productRequest));
    }
}
