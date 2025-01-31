package com.example.pretice2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@Entity
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "member_entity")
@SequenceGenerator(
        name = "member_entity_seq",
        sequenceName = "member_entity_seq",
        initialValue = 1,
        allocationSize = 1
)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_entity_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

}
