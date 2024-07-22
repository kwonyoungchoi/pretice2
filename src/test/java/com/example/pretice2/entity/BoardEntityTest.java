package com.example.pretice2.entity;

import com.example.pretice2.dto.BoardDTO;
import com.example.pretice2.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardEntityTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void BoardInsertTest() {
        BoardEntity boardEntity = BoardEntity.builder()
                .subject("게시물 제목")
                .content("게시물 내용")
                .build();
        System.out.println(boardRepository.save(boardEntity));
    }

    @Test
    public void BoardUpdateTest() {
        BoardEntity boardEntity = BoardEntity.builder()
                .id(2)
                .subject("수정 게시물")
                .content("내용 수정")
                .build();
        System.out.println(boardRepository.save(boardEntity));
    }

    @Test
    public void BoardListTest() {
        List<BoardEntity> list = boardRepository.findAll();
        System.out.println(list.toString());
    }

    @Test
    public void ListOneTest() {
        Optional<BoardEntity> list = boardRepository.findById(2);
        System.out.println(list.toString());
    }

    @Test
    public void deleteTest() {
        boardRepository.deleteById(2);
    }

    @Test
    public void testCRUDOperations() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setSubject("게시물 제목");
        boardEntity.setContent("게시물 내용");
        boardEntity = boardRepository.save(boardEntity);
        System.out.println("등록 자료 : " + boardEntity);

        Optional<BoardEntity> savedBoard = boardRepository.findById(boardEntity.getId());

        assertTrue(savedBoard.isPresent());

        assertEquals("게시물 제목", savedBoard.get().getSubject());
        System.out.println("자료 조회 : " + savedBoard.get());

        savedBoard.get().setSubject("게시물 수정");
        boardRepository.save(savedBoard.get());
        System.out.println("수정한 자료 : " + savedBoard.get());

        Optional<BoardEntity> updatedBoard = boardRepository.findById(boardEntity.getId());
        assertTrue(updatedBoard.isPresent());
        assertEquals("게시물 수정", updatedBoard.get().getSubject());
        System.out.println("수정검증 : " + updatedBoard.get());

        boardRepository.deleteById(boardEntity.getId());
        System.out.println("삭제할 자료 : " + boardEntity.getId());

        Optional<BoardEntity> deletedBoard = boardRepository.findById(boardEntity.getId());
        assertTrue(deletedBoard.isEmpty());
        System.out.println("삭제검증 조회 번호 : " + boardEntity.getId() + "없음");
    }

    @Test
    public void testDTOConcversion() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setSubject("DTOConversionTest");
        boardEntity = boardRepository.save(boardEntity);

        BoardDTO boardDTO = BoardDTO.builder()
                .id(boardEntity.getId())
                .subject(boardEntity.getSubject())
                .build();

        assertEquals(boardEntity.getId(), boardDTO.getId());
        assertEquals(boardEntity.getSubject(), boardDTO.getSubject());

        System.out.println("원본 BoardEntity : " + boardEntity);
        System.out.println("변환 BoardDTO : " + boardDTO);

    }

}