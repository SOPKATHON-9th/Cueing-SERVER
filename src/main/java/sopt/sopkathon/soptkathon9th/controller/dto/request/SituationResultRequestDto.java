package sopt.sopkathon.soptkathon9th.controller.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SituationResultRequestDto {

    private final String surviveState;
    private final String situationWhat;
    private final String situationWhere;
    private final String situationIn;

}
