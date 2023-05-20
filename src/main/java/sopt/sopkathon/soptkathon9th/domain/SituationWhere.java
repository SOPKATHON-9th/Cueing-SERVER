package sopt.sopkathon.soptkathon9th.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SituationWhere {

    HOME("집"),
    SCHOOL("학교"),
    CAR("차 안"),
    SUBWAY("지하철"),
    ;


    private String where;
}
