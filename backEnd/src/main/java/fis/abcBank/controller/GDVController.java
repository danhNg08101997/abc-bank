package fis.abcBank.controller;

import fis.abcBank.constant.APIConstant;
import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.BaseResponse;
import fis.abcBank.dto.response.GDVResponse;
import fis.abcBank.dto.response.PagingResponse;
import fis.abcBank.service.GDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConstant.API_GDV)
public class GDVController {
    @Autowired
    GDVService gdvService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>create(@RequestBody GDVRequest gdvRequest){
        return ResponseEntity.status(HttpStatus.OK).body(gdvService.createGDV(gdvRequest));
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>upadte(@RequestBody GDVRequest gdvRequest){
        return ResponseEntity.status(HttpStatus.OK).body(gdvService.updateGDV(gdvRequest));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse>delete(@RequestBody GDVRequest gdvRequest){
        return ResponseEntity.status(HttpStatus.OK).body(gdvService.deleteGDV(gdvRequest));
    }
    @PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<GDVResponse>>getAll(@RequestBody GDVRequest gdvRequest){
        return ResponseEntity.status(HttpStatus.OK).body(gdvService.getAllGDV(gdvRequest));
    }
}
