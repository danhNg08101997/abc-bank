package fis.abcBank.dto.request;

import fis.abcBank.dto.response.CustomerResponse;
import fis.abcBank.dto.response.GDVResponse;

import java.util.List;
import java.util.Map;

public class CustomerRequest extends CustomerResponse {
    private int pageNumber;
    private int pageSize;
    private String exportType;
    private String fileType;
    private List<GDVResponse> successList;
    private List<Map<String, Object>> errorList;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<GDVResponse> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<GDVResponse> successList) {
        this.successList = successList;
    }

    public List<Map<String, Object>> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Map<String, Object>> errorList) {
        this.errorList = errorList;
    }
}
