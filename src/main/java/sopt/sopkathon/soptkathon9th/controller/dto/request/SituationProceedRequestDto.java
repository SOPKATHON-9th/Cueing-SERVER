package sopt.sopkathon.soptkathon9th.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SituationProceedRequestDto {

    private final Long userId;
    private final String situationWhat;
    private final String situationWhere;
    private final String situationIn;
}
