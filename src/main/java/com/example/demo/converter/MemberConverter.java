package com.example.demo.converter;

import com.example.demo.entity.Member;
import com.example.demo.rest.dto.MemberCreateDTO;
import com.example.demo.rest.dto.MemberDTO;
import com.example.demo.rest.dto.MemberDetailDTO;
import com.example.demo.rest.dto.MemberUpdateDTO;
import org.mapstruct.Builder;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author meow
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface MemberConverter {

    /**
     * convert to detail
     */
    MemberDetailDTO toDetail(Member member);

    /**
     * convert to MemberDTO
     */
    MemberDTO toMemberDTO(Member member);

    /**
     * convert to List<MemberDTO>
     */
    @IterableMapping(elementTargetType = MemberDTO.class)
    List<MemberDTO> toMemberDTO(List<Member> members);

    /**
     * copy properties
     */
    void copyProperties(MemberUpdateDTO updateDTO, @MappingTarget Member member);

    /**
     * convert to Member
     */
    Member toMember(MemberCreateDTO createDTO);
}
