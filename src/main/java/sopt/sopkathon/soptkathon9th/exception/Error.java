package sopt.sopkathon.soptkathon9th.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

    /**
     * 400 BAD REQUEST
     */
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),

    /**
     * 404 NOT FOUND
     */
    NOT_EXIST_SITUATION_DATA_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 상황 정보입니다"),
    NOT_EXIST_SITUATION_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 상황입니다"),

    /**
     * 409 CONFLICT
     */


    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}