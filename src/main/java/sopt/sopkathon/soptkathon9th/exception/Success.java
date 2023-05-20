package sopt.sopkathon.soptkathon9th.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    /**
     * 200 OK
     */
    FIND_RESULT_SUCCESS(HttpStatus.OK, "생존 결과 전송에 성공했습니다."),
    PROCEED_MISSION_REGISTER_SUCCESS(HttpStatus.OK, "진행한 미션 등록에 성공하였습니다."),
    FIND_MY_PAGE_DATA_SUCCESS(HttpStatus.OK, "마이 페이지 불러오기에 성공했습니다."),

    /**
     * 204 No Content
     */
    NO_CONTENT_SITUATION_PROCEED_DATA_EXCEPTION(HttpStatus.NO_CONTENT, "유저에 대한 상황별 데이터가 존재하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}