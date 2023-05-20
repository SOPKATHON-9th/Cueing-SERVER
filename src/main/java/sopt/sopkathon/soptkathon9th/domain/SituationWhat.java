package sopt.sopkathon.soptkathon9th.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SituationWhat {

    FIRE("화재"),
    EARTHQUAKE("지진"),
    ZOMBIE("좀비"),
    STORM("폭우"),
    ;

    private String what;
}
