package lilbunnyrabbit.matchmaking.exception.service;

public class PlayerException extends Exception {

    private Code code;

    public PlayerException(Code code) {
        super(code.name());
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public enum Code {
        INTERNAL,
        PLAYER_EXISTS,
        PLAYER_NOT_EXISTS
    }
}