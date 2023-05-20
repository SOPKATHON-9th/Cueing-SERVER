package sopt.sopkathon.soptkathon9th.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.sopkathon.soptkathon9th.common.dto.ApiResponse;
import sopt.sopkathon.soptkathon9th.controller.dto.request.SituationResultRequestDto;
import sopt.sopkathon.soptkathon9th.exception.Success;
import sopt.sopkathon.soptkathon9th.service.SituationService;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/situation")
public class SituationController {

    private final SituationService situationService;

    @GetMapping("/result")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getResult(@RequestBody final SituationResultRequestDto request) {
        return ApiResponse.success(Success.FIND_RESULT_SUCCESS ,situationService.getSituationResult(request));
    }
}
