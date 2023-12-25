package com.kdt.mappers;

import org.mapstruct.Mapper;

import com.kdt.domain.entities.Report;
import com.kdt.dto.ReportDTO;

@Mapper(componentModel = "spring")
public interface ReportMapper extends GenericMapper<ReportDTO,Report>{

}
