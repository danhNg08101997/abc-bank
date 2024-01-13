package fis.abcBank.mapper;

import fis.abcBank.dto.request.GDVRequest;
import fis.abcBank.dto.response.GDVResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GDVMapper {
    int create(GDVRequest gdvRequest);
    int update(GDVRequest gdvRequest);
    int delete(GDVRequest gdvRequest);
    List<GDVResponse>getGDVList(GDVRequest gdvRequest);
    int count(GDVRequest gdvRequest);
}
