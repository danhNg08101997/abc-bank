package fis.abcBank.controller;

import fis.abcBank.constant.APIConstant;
import fis.abcBank.dto.request.CustomerRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.CustomerResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConstant.API_CUSTOMER)
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>create(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.createCustomer(customerRequest));
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>update(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerRequest));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>delete(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(customerRequest));
    }
    @PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<CustomerResponse>>getAll(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer(customerRequest));
    }
}
