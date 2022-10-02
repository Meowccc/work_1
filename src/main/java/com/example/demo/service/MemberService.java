package com.example.demo.service;

import com.example.demo.converter.MemberConverter;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;
import com.example.demo.rest.dto.MemberCreateDTO;
import com.example.demo.rest.dto.MemberDTO;
import com.example.demo.rest.dto.MemberDetailDTO;
import com.example.demo.rest.dto.MemberUpdateDTO;
import com.example.demo.rest.dto.PageDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @author meow
 */
@Service
@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService extends BaseService{

    private final MemberRepo memberRepo;
    private final MemberConverter memberConverter;

    public MemberDetailDTO findById(@Valid final String id) {
        return memberRepo.findById(id)
                .map(memberConverter::toDetail)
                .orElseThrow();
    }

    public PageDataDTO<MemberDTO> listMembers(final int page, final int size) {
        final Page<Member> memberPage = memberRepo.findAll(PageRequest.of(page, size));
        final List<MemberDTO> members = memberConverter.toMemberDTO(memberPage.getContent());
        return convert(memberPage, members);
    }

    @Transactional
    public MemberDTO create(final MemberCreateDTO dto) {
        final Member member = memberConverter.toMember(dto);
        return memberConverter.toMemberDTO(memberRepo.saveAndFlush(member));
    }

    @Transactional
    public MemberDTO update(final String id, final MemberUpdateDTO dto) {
        final Member member = memberRepo.findById(id).orElseThrow();
        memberConverter.copyProperties(dto, member);
        return memberConverter.toMemberDTO(memberRepo.saveAndFlush(member));
    }

    @Transactional
    public void delete(@Valid final String id) {
        memberRepo.delete(memberRepo.findById(id).orElseThrow());
    }

}
