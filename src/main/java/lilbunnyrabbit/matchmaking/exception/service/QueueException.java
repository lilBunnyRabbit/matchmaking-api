package lilbunnyrabbit.matchmaking.exception.service;

public class QueueException extends Exception {

    private Code code;

    public QueueException(Code code) {
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
        QUEUE_EXISTS,
        QUEUE_NOT_EXISTS,
        FAILED_CREATE_LOBBY_VC,
        FAILED_SAVE_QUEUE_TO_PLAYER,
        PLAYER_NOT_IN_QUEUE,
        PLAYER_IN_QUEUE
    }
}