package lilbunnyrabbit.matchmaking.exception.service;

public class GuildException extends Exception {

    private Issue issue;

    public GuildException(Issue issue) {
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
        GUILD_EXISTS,
        GUILD_NOT_EXISTS
    }
}