package fis.abcBank.dto.response;

import java.util.ArrayList;
import java.util.List;
public class PagingResponse <T>{
    private List<T> content;
    private long totalElements;
    private String errorCode;
    private String errorDesc;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

//    =======================
public PagingResponse() {
}
//    public PagingResponse(Page<T> page) {
//        if (page == null) {
//            this.content = new ArrayList<>();
//            this.totalElements = 0;
//            return;
//        }
//        this.content = page.getContent();
//        this.totalElements = page.getTotalElements();
//    }
    public PagingResponse(List<T> content, long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }
}
