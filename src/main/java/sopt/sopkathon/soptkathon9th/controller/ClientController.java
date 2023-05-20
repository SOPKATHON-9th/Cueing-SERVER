package sopt.sopkathon.soptkathon9th.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.sopkathon.soptkathon9th.common.dto.ApiResponse;
import sopt.sopkathon.soptkathon9th.exception.Success;
import sopt.sopkathon.soptkathon9th.service.ClientService;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    public void addUser() {
        clientService.addUser();
    }

    @GetMapping("/myPage")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getMyPage(@RequestParam final Long userId) {
        return ApiResponse.success(Success.FIND_MY_PAGE_DATA_SUCCESS, clientService.getMyPage(userId));
    }
}
