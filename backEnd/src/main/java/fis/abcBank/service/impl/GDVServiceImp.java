package fis.abcBank.service.impl;

import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.GDVResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.dto.response.ProductResponse;
import fis.abcBank.mapper.GDVMapper;
import fis.abcBank.service.GDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GDVServiceImp implements GDVService {
    @Autowired
    GDVMapper gdvMapper;
    @Override
    public BaseResponse createGDV(GDVRequest gdvRequest) {
        gdvRequest.setGdvAvailable(1);
        if (gdvRequest.getGdvName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tham số không được để trống");
        }
        int countCreate = gdvMapper.create(gdvRequest);
        if (countCreate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Thêm dữ liệu thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Thêm dữ liệu thất bại");
    }

    @Override
    public BaseResponse updateGDV(GDVRequest gdvRequest) {
        if (gdvRequest.getGdvID() <= 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        if (gdvRequest.getGdvName().isEmpty()){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số không được để trống");
        }
        int countUpdate = gdvMapper.update(gdvRequest);
        if(countUpdate > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()),"Cập nhật dữ liệu thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật dữ liệu thất bại");
    }

    @Override
    public BaseResponse deleteGDV(GDVRequest gdvRequest) {
        if (gdvRequest.getGdvID() <= 0){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Tham số ID không hợp lệ");
        }
        int deleteCount = gdvMapper.delete(gdvRequest);
        if (deleteCount > 0){
            return new BaseResponse(String.valueOf(HttpStatus.OK.value()), "Xóa thành công");
        }
        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Xóa thất bại");
    }

    @Override
    public PagingResponse<GDVResponse> getAllGDV(GDVRequest gdvRequest) {
        List<GDVResponse> gdvList = gdvMapper.getGDVList(gdvRequest);
        int totalElements = 0;
        if (gdvRequest.getPageNumber()>0&&gdvRequest.getPageSize()>0){
            totalElements = gdvMapper.count(gdvRequest);
        }
        return new PagingResponse<GDVResponse>(gdvList, totalElements, String.valueOf(HttpStatus.OK.value()),HttpStatus.OK.name());
    }
}
