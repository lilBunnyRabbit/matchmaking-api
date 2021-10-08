package lilbunnyrabbit.matchmaking.exception.service;

public class GuildException extends Exception {

    private Code code;

    public GuildException(Code code) {
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
        GUILD_EXIST,
        GUILD_NOT_EXIST,
        PLAYER_NOT_EXIST,
        GUILD_PLAYER_EXIST,
        FAILED_CREATE_CATEGORY
    }
}