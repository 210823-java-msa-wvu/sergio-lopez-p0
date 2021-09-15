package dev.lopez.exceptions;

public class NoUsernameFound extends RuntimeException {
    public NoUsernameFound(){super("Username not Found.");}
}
