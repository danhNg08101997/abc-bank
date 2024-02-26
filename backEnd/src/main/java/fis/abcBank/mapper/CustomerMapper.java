package fis.abcBank.mapper;

import fis.abcBank.dto.request.CustomerRequest;
import fis.abcBank.dto.response.CustomerResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int create(CustomerRequest customerRequest);
    int update(CustomerRequest customerRequest);
    int delete(CustomerRequest customerRequest);
    List<CustomerResponse>getCustomerList(CustomerRequest customerRequest);
    int count(CustomerRequest customerRequest);
}
