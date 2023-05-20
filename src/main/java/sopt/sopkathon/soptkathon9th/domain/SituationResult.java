package sopt.sopkathon.soptkathon9th.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SituationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situationProceedId")
    private SituationProceed situationProceed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situationId")
    private Situation situation;

    @Column(name = "servive_state", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SurviveState surviveState;

    @Column(nullable = false)
    private String result;
}
