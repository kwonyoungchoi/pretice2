package com.example.pretice2.repository;

import com.example.pretice2.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Query("SELECT u FROM BoardEntity u where u.subject like :subject")
    List<BoardEntity> search(@Param("subject") String name);

}
