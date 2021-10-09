package lilbunnyrabbit.matchmaking.exception.service;

public class MatchException extends Exception{
    private MatchException.Code code;

    public MatchException(MatchException.Code code) {
        super(code.name());
        this.code = code;
    }

    public MatchException.Code getCode() {
        return code;
    }

    public void setCode(MatchException.Code code) {
        this.code = code;
    }

    public enum Code{
        NOT_ENOUGH_PLAYERS
    }
}
