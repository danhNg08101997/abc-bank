package fis.abcBank.service.impl;

import fis.abcBank.dto.request.UserRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.UserResponse;
import fis.abcBank.mapper.UserMapper;
import fis.abcBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public BaseResponse createUser(UserRequest userRequest) {
        if(     userRequest.getUsername().isEmpty()  ||
                userRequest.getUserPassword().isEmpty() ||
                userRequest.getUserRole().isEmpty())
        {
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số bắt buộc không được trống");
        }
//        Khởi tạo dữ liệu
        int countCreate = userMapper.create(userRequest);
        if (countCreate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()),"Tạo mới thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateUser(UserRequest userRequest) {
        if(     userRequest.getUsername().isEmpty()  ||
                userRequest.getUserPassword().isEmpty() ||
                userRequest.getUserRole().isEmpty())
        {
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số bắt buộc không được trống");
        }
//        Cập nhật dữ liệu
        int countUpdate = userMapper.update(userRequest);
        if(countUpdate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Cập nhật thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Cập nhật thất bại");
    }

    @Override
    public PagingResponse<UserResponse> getAllUser(UserRequest request) {
        List<UserResponse>userList = userMapper.getUserList(request);
        int totalElements = 0;
        if(request.getPageNumber() > 0 && request.getPageSize() > 0){
            totalElements = userMapper.count(request);
        }
        return new PagingResponse<UserResponse>(userList, totalElements, String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.name());
    }

    @Override
    public BaseResponse deleteUser(UserRequest request) {
        if (request.getUserID() <= 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
            int deleteCount = userMapper.delete(request);
            if (deleteCount > 0){
                return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Xóa thành công");
            }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Xóa thất bại");
    }
}
