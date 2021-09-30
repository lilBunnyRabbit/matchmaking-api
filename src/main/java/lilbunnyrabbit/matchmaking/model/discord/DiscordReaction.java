package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordReaction {

    @NotEmpty
    private Integer count;

    @NotEmpty
    private Boolean me;

    @NotEmpty
    private DiscordEmoji.Partial emoji;

    public DiscordReaction() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getMe() {
        return me;
    }

    public void setMe(Boolean me) {
        this.me = me;
    }

    public DiscordEmoji.Partial getEmoji() {
        return emoji;
    }

    public void setEmoji(DiscordEmoji.Partial emoji) {
        this.emoji = emoji;
    }
}
