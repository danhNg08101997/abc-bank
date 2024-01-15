package fis.abcBank.service;

import fis.abcBank.dto.request.CustomerRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.CustomerResponse;
import fis.abcBank.dto.response.PagingResponse;

public interface CustomerService {
    BaseResponse createCustomer(CustomerRequest customerRequest);
    BaseResponse updateCustomer(CustomerRequest customerRequest);
    BaseResponse deleteCustomer(CustomerRequest customerRequest);
    PagingResponse<CustomerResponse> getAllCustomer(CustomerRequest customerRequest);
}
