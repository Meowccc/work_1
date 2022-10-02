package com.example.demo.rest.controller;

import com.example.demo.rest.dto.MemberCreateDTO;
import com.example.demo.rest.dto.MemberDTO;
import com.example.demo.rest.dto.MemberDetailDTO;
import com.example.demo.rest.dto.MemberUpdateDTO;
import com.example.demo.rest.dto.PageDataDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meow
 */
@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("{id}")
    public MemberDetailDTO getMemberById(@PathVariable("id") String id) {
        return memberService.findById(id);
    }

    @GetMapping
    public PageDataDTO<MemberDTO> listMembers(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return memberService.listMembers(page, size);
    }

    @PostMapping
    public MemberDTO create(@RequestBody MemberCreateDTO createDTO) {
        return memberService.create(createDTO);
    }

    @PutMapping("{id}")
    public MemberDTO update(@PathVariable("id") String id, @RequestBody MemberUpdateDTO updateDTO) {
        return memberService.update(id, updateDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        memberService.delete(id);
    }
}
