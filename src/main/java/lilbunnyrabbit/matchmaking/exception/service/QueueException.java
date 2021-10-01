package lilbunnyrabbit.matchmaking.exception.service;

public class QueueException extends Exception {

    private Issue issue;

    public QueueException(Issue issue) {
        super(issue.name());
        this.issue = issue;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public enum Issue {
        INTERNAL,
        QUEUE_EXISTS,
        QUEUE_NOT_EXISTS,
        FAILED_CREATE_LOBBY_VC,
        FAILED_SAVE_QUEUE_TO_PLAYER
    }
}