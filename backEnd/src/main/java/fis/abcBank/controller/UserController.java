package fis.abcBank.controller;

import fis.abcBank.constant.APIConstant;
import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.UserResponse;
import fis.abcBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIConstant.API_USER)
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userRequest));
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userRequest));
    }
    @PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<UserResponse>>getAll(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser(request));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> delete(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(request));
    }
}
