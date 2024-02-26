package fis.abcBank.service.impl;

import fis.abcBank.dto.request.CustomerRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.CustomerResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.mapper.CustomerMapper;
import fis.abcBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public BaseResponse createCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getCustomerName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tham số không được để trống");
        }
        int countCreate = customerMapper.create(customerRequest);
        if (countCreate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Thêm dữ liệu thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Thêm dữ liệu thất bại");
    }

    @Override
    public BaseResponse updateCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getCustomerID() < 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        if (customerRequest.getCustomerName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tham số không được để trống");
        }
        int countUpdate = customerMapper.update(customerRequest);
        if (countUpdate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()),"Cập nhật dữ liệu thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật dữ liệu thất bại");
    }

    @Override
    public BaseResponse deleteCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getCustomerID() < 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        int countDelete = customerMapper.delete(customerRequest);
        if (countDelete > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()),"Xóa dữ liệu thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Xóa dữ liệu thất bại");
    }

    @Override
    public PagingResponse<CustomerResponse> getAllCustomer(CustomerRequest customerRequest) {
        List<CustomerResponse> customerList = customerMapper.getCustomerList(customerRequest);
        int totalElements = 0;
        if (customerRequest.getPageNumber()>0 && customerRequest.getPageSize()>0){
            totalElements = customerMapper.count(customerRequest);
        }
        return new PagingResponse<CustomerResponse>(customerList,totalElements,String.valueOf(HttpStatus.OK.value()),HttpStatus.OK.name());
    }
}
