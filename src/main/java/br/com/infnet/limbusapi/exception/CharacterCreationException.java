package br.com.infnet.limbusapi.exception;

public class CharacterCreationException extends RuntimeException{
    public CharacterCreationException(String message, Throwable ex) {
        super(message, ex);
    }
}
