package fis.abcBank.service;

import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.BaseResponse;

public interface UserService {
    BaseResponse createUser(UserRequest request);
}
