package com.example.pretice2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@Entity
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "board_entity")
@SequenceGenerator(
        name = "member_entity_seq",
        sequenceName = "member_entit_seq",
        initialValue = 1,
        allocationSize = 1
)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_entity_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subjact", nullable = false, length = 50)
    private String subject;

    @Column(name = "content", length = 100)
    private String content;
}
