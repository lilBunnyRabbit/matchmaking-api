package lilbunnyrabbit.matchmaking.exception.service;

public class PlayerException extends Exception {

    private Issue issue;

    public PlayerException(Issue issue) {
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
        PLAYER_EXISTS,
        PLAYER_NOT_EXISTS
    }
}