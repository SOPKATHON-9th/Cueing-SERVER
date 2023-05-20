package sopt.sopkathon.soptkathon9th.exception.model;

import sopt.sopkathon.soptkathon9th.exception.Error;

public class ConflictException extends CustomException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
