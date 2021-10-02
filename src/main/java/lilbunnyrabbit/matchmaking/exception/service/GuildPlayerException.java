package lilbunnyrabbit.matchmaking.exception.service;

public class GuildPlayerException extends Exception {

    private Issue issue;

    public GuildPlayerException(Issue issue) {
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
        GUILD_PLAYER_EXISTS,
        GUILD_PLAYER_NOT_EXISTS,
        GUILD_NOT_EXISTS,
        IN_QUEUE,
        NOT_IN_QUEUE,
        FAILED_JOIN_QUEUE,
        FAILED_LEAVE_QUEUE
    }
}