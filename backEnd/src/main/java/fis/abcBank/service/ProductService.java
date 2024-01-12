package fis.abcBank.service;

import fis.abcBank.dto.request.ProductRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.ProductResponse;

public interface ProductService {
    BaseResponse createProduct(ProductRequest productRequest);
    BaseResponse updateProduct(ProductRequest productRequest);
    BaseResponse deleteProduct(ProductRequest productRequest);
    PagingResponse<ProductResponse>getAllProduct(ProductRequest productRequest);
}
