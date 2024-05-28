package fis.abcBank.service.impl;

import fis.abcBank.dto.request.ProductRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.ProductResponse;
import fis.abcBank.mapper.ProductMapper;
import fis.abcBank.service.ProductService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public BaseResponse createProduct(ProductRequest productRequest) {
        if (productRequest.getProductName() == null || productRequest.getProductName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tên sản phẩm không được để trống");
        }
        if (productRequest.getProductCode() == null || productRequest.getProductCode().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Mã sản phẩm không được để trống");
        }
        int countCreate = productMapper.create(productRequest);
        if (countCreate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateProduct(ProductRequest productRequest) {
        if (productRequest.getProductID() <= 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        if (productRequest.getProductName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tên sản phẩm không được để trống");
        }
        int countUpdate = productMapper.update(productRequest);
        if (countUpdate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Cập nhật thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật thất bại");
    }

    @Override
    public BaseResponse deleteProduct(ProductRequest productRequest) {
        if (productRequest.getProductID() <= 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        int deleteCount = productMapper.delete(productRequest);
        if (deleteCount > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Xóa thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Xóa thất bại");
    }

    @Override
    public PagingResponse<ProductResponse> getAllProduct(ProductRequest productRequest) {
        List<ProductResponse> productList = productMapper.getProductList(productRequest);
        int totalElements = 0;
        if (productRequest.getPageNumber()>0 && productRequest.getPageSize()>0){
            totalElements = productMapper.count(productRequest);
        }
        return new PagingResponse<ProductResponse>(productList, totalElements, String.valueOf(HttpStatus.OK.value()),HttpStatus.OK.name());
    }
}
