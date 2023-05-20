package sopt.sopkathon.soptkathon9th.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ClientMyPageResponseDto {
    private final int proceedCount;
    private final List<SituationProceedDto> situationProceedDtos;

    public static ClientMyPageResponseDto from(int proceedCount, List<SituationProceedDto> situationProceedDtos) {
        return new ClientMyPageResponseDto(proceedCount, situationProceedDtos);
    }

}
