package lilbunnyrabbit.matchmaking.service.discord.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ChannelRequest implements Serializable {
    private String name;
    private Integer type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String topic;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer bitrate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("user_limit")
    private Integer userLimit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rate_limit_per_user")
    private Integer rateLimitPerUser;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer position;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("permission_overwrites")
    private List<String> permissionOverwrites;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("parent_id")
    private String parentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean nsfw;

    public ChannelRequest() {}
    public ChannelRequest(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    public Integer getRateLimitPerUser() {
        return rateLimitPerUser;
    }

    public void setRateLimitPerUser(Integer rateLimitPerUser) {
        this.rateLimitPerUser = rateLimitPerUser;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<String> getPermissionOverwrites() {
        return permissionOverwrites;
    }

    public void setPermissionOverwrites(List<String> permissionOverwrites) {
        this.permissionOverwrites = permissionOverwrites;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }
}
