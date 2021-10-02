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
        GUILD_EXIST,
        GUILD_NOT_EXIST,
        PLAYER_NOT_EXIST,
        GUILD_PLAYER_EXIST,
        FAILED_CREATE_CATEGORY
    }
}