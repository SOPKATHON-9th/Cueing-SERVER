package sopt.sopkathon.soptkathon9th.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SituationProceedDto {

    private final String situationWhat;
    private final String situationWhere;
    private final String situationIn;
    private final boolean isProceed;
}
