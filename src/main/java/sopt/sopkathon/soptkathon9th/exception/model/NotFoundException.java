package sopt.sopkathon.soptkathon9th.exception.model;


import sopt.sopkathon.soptkathon9th.exception.Error;

public class NotFoundException extends CustomException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}