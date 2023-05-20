package sopt.sopkathon.soptkathon9th.controller.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SituationResultResponseDto {

    String result;

    public static SituationResultResponseDto from(String result) {
        return new SituationResultResponseDto(result);
    }
}
