package fis.abcBank.mapper;

import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int create(UserRequest request);
    int update(UserRequest request);
    int count(UserRequest request);
    List<UserResponse> getUserList(UserRequest request);
    int delete(UserRequest request);
}
