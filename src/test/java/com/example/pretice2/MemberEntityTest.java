package com.example.pretice2;


import com.example.pretice2.dto.MemberDTO;
import com.example.pretice2.entity.MemberEntity;
import com.example.pretice2.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MemberEntityTest {

    @Autowired
    public MemberRepository memberRepository;

    @Test
    public void MemberInsertTest() {
        MemberEntity memberEntity = MemberEntity.builder()
                .username("홍길동")
                .build();
        System.out.println(memberRepository.save(memberEntity));
    }

    @Test
    public void MemberUpdateTest() {
        MemberEntity memberEntity = MemberEntity.builder()
                .id(1)
                .username("수진이")
                .build();
        System.out.println(memberRepository.save(memberEntity));
    }

    @Test
    public void MemberListTest() {
        List<MemberEntity> list = memberRepository.findAll();
        System.out.println(list.toString());
    }

    @Test
    public void listOneTest() {
        Optional<MemberEntity> list = memberRepository.findById(1);
        System.out.println(list.toString());
    }

    @Test
    public void deleteTest() {
        memberRepository.deleteById(1);
    }

    @Test
    public void testCRUDOperations() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername("TestUser");
        memberEntity = memberRepository.save(memberEntity);
        System.out.println("등록 자료 : " + memberEntity);

        Optional<MemberEntity> savedMember = memberRepository.findById(memberEntity.getId());
        assertTrue(savedMember.isPresent());
        assertEquals("TestUser",savedMember.get().getUsername());
        System.out.println("자료 조회 : " + savedMember.get());

        savedMember.get().setUsername("UpdateUser");
        memberRepository.save(savedMember.get());
        System.out.println("수정한 자료 : " + savedMember.get());

        Optional<MemberEntity> updatedMember = memberRepository.findById(memberEntity.getId());
        assertTrue(updatedMember.isPresent());
        assertEquals("UpdateUser", updatedMember.get().getUsername());
        System.out.println("수정검증 : " + updatedMember.get());

        memberRepository.deleteById(memberEntity.getId());
        System.out.println("삭제할 자료 : " + memberEntity.getId());

        Optional<MemberEntity> deletedMember = memberRepository.findById(memberEntity.getId());
        assertTrue(deletedMember.isEmpty());
        System.out.println("삭제검증 : 조회 번호 : " + memberEntity.getId() + " 없음");
    }

    @Test
    public void testDTOConversion() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername("DTOConversionTestUser");
        memberEntity = memberRepository.save(memberEntity);

        MemberDTO memberDTO = MemberDTO.builder()
                .id(memberEntity.getId())
                .username(memberEntity.getUsername())
                .build();

        assertEquals(memberEntity.getId(), memberDTO.getId());
        assertEquals(memberEntity.getUsername(), memberDTO.getUsername());

        System.out.println("원본 MemberEntity : " + memberEntity);
        System.out.println("변환 MemberDTD : " + memberDTO);
    }

}
