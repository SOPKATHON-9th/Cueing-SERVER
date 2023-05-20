package sopt.sopkathon.soptkathon9th.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SituationIn {

    STATION("지하철 역"),
    PLATFORM("플랫폼"),
    IN_SUBWAY("열차"),
    ELEVATOR("엘레베이터"),
    ;


    private String in;
}
