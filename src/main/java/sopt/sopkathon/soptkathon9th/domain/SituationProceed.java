package sopt.sopkathon.soptkathon9th.domain;

import lombok.*;
import sopt.sopkathon.soptkathon9th.controller.dto.response.SituationProceedDto;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SituationProceed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "situation_proceed_id")
    private Long situationProceedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situationId")
    private Situation situation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @Column(name = "is_proceed", nullable = false)
    private boolean isProceed;


    public SituationProceedDto toDto() {
        return SituationProceedDto.builder()
                .situationWhat(situation.getSituationWhat().name())
                .situationWhere(situation.getSituationWhere().name())
                .situationIn(situation.getSituationIn().name())
                .isProceed(isProceed)
                .build();
    }
}
