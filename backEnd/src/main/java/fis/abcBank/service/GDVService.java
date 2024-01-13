package fis.abcBank.service;

import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.GDVResponse;
import fis.abcBank.dto.response.PagingResponse;

public interface GDVService {
    BaseResponse createGDV(GDVRequest gdvRequest);
    BaseResponse updateGDV(GDVRequest gdvRequest);
    BaseResponse deleteGDV(GDVRequest gdvRequest);
    PagingResponse<GDVResponse>getAllGDV(GDVRequest gdvRequest);
}
