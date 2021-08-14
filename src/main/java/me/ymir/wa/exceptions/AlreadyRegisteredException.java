package me.ymir.wa.exceptions;

public class AlreadyRegisteredException extends Exception {
    public AlreadyRegisteredException(String desc){
        super(desc);
    }
}
