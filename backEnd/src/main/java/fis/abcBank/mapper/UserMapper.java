package fis.abcBank.mapper;

import fis.abcBank.dto.request.UserRequest;

public interface UserMapper {
int createUser(UserRequest request);
}
