package sopt.sopkathon.soptkathon9th.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Situation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "situation_id")
    private Long situationId;

    @Column(name = "situation_what", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SituationWhat situationWhat;

    @Column(name = "situation_where", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SituationWhere situationWhere;

    @Column(name = "situation_in", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SituationIn situationIn;
}
