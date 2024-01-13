package fis.abcBank.service;

import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.BaseResponse;

public interface GDVService {
    BaseResponse createGDV(GDVRequest gdvRequest);
}
