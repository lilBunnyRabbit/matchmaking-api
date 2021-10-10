package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DReaction {

    @NotEmpty
    private Integer count;

    @NotEmpty
    private Boolean me;

    @NotEmpty
    private DEmoji.Partial emoji;

    public DReaction() {
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

    public DEmoji.Partial getEmoji() {
        return emoji;
    }

    public void setEmoji(DEmoji.Partial emoji) {
        this.emoji = emoji;
    }
}
