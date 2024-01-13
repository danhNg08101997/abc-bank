package fis.abcBank.service.impl;

import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.mapper.GDVMapper;
import fis.abcBank.service.GDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GDVServiceImp implements GDVService {
    @Autowired
    GDVMapper gdvMapper;
    @Override
    public BaseResponse createGDV(GDVRequest gdvRequest) {
        if (gdvRequest.getGdvName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tham số không được để trống");
        }
        int countCreate = gdvMapper.create(gdvRequest);
        return null;
    }
}
