package lilbunnyrabbit.matchmaking.exception.service;

public class GuildPlayerException extends Exception {

    private Code code;

    public GuildPlayerException(Code code) {
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
        GUILD_PLAYER_EXISTS,
        GUILD_PLAYER_NOT_EXISTS,
        GUILD_NOT_EXISTS,
        IN_QUEUE,
        NOT_IN_QUEUE,
        FAILED_JOIN_QUEUE,
        FAILED_LEAVE_QUEUE
    }
}