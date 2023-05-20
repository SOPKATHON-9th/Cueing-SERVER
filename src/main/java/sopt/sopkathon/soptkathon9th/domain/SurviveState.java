package sopt.sopkathon.soptkathon9th.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SurviveState {
    SAFE(2),
    WARNING(1),
    FAIL(0);

    private int stateCode;
}
