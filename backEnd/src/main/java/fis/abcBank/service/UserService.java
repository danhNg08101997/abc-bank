package fis.abcBank.service;

import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.UserResponse;

public interface UserService {
    BaseResponse createUser(UserRequest request);
    BaseResponse updateUser(UserRequest request);
    PagingResponse<UserResponse> getAllUser(UserRequest request);
}
