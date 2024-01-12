package fis.abcBank.mapper;

import fis.abcBank.dto.request.ProductRequest;
import fis.abcBank.dto.response.ProductResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
int create (ProductRequest productRequest);
int update(ProductRequest productRequest);
int delete(ProductRequest productRequest);
List<ProductResponse>getProductList(ProductRequest productRequest);
int count(ProductRequest productRequest);
}
