package fis.abcBank.mapper;

import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int create(UserRequest userRequest);
    int update(UserRequest userRequest);
    int count(UserRequest userRequest);
    List<UserResponse> getUserList(UserRequest userRequest);
    int delete(UserRequest userRequest);
}
