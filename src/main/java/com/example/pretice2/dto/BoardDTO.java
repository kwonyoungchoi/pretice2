package com.example.pretice2.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BoardDTO {


    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime moddate;
}
