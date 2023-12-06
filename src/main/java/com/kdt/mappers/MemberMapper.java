package com.kdt.mappers;

import org.mapstruct.Mapper;

import com.kdt.domain.entities.Member;
import com.kdt.dto.MemberDTO;

@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper<MemberDTO, Member>{

}
