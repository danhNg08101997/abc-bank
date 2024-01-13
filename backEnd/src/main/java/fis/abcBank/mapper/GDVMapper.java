package fis.abcBank.mapper;

import fis.abcBank.dto.request.GDVRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GDVMapper {
    int create(GDVRequest gdvRequest);
}
