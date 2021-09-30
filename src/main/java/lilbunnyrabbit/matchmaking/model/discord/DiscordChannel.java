package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordChannel {

    @NotEmpty
    private String id;

    @NotEmpty
    private Integer type; // Type

    @JsonProperty("guild_id")
    private String guildId;

    private Integer position;

    @JsonProperty("permission_overwrites")
    private List<DiscordOverwrite> permissionOverwrites;

    private String name;

    private String topic;

    private Boolean nsfw;

    @JsonProperty("last_message_id")
    private String lastMessageId;

    private Integer bitrate;

    @JsonProperty("user_limit")
    private Integer userLimit;

    @JsonProperty("rate_limit_per_user")
    private Integer rateLimitPerUser;

    private List<DiscordUser> recipients;

    private String icon;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("last_pin_timestamp")
    private String lastPinTimestamp;

    @JsonProperty("rtc_region")
    private String rtcRegion; // Todo: VoiceRegion

    @JsonProperty("video_quality_mode")
    private Integer videoQualityMode; // Todo: VideoQualityMode

    @JsonProperty("message_count")
    private Integer messageCount;

    @JsonProperty("member_count")
    private Integer memberCount;

    @JsonProperty("thread_metadata")
    private Object threadMetadata; // Todo: ThreadMetadata

    private Object member; // Todo: ThreadMember

    @JsonProperty("default_auto_archive_duration")
    private Integer defaultAutoArchiveDuration;

    private String permissions;

    public DiscordChannel() {
    }

    public DiscordChannel(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<DiscordOverwrite> getPermissionOverwrites() {
        return permissionOverwrites;
    }

    public void setPermissionOverwrites(List<DiscordOverwrite> permissionOverwrites) {
        this.permissionOverwrites = permissionOverwrites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
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

    public List<DiscordUser> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<DiscordUser> recipients) {
        this.recipients = recipients;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLastPinTimestamp() {
        return lastPinTimestamp;
    }

    public void setLastPinTimestamp(String lastPinTimestamp) {
        this.lastPinTimestamp = lastPinTimestamp;
    }

    public String getRtcRegion() {
        return rtcRegion;
    }

    public void setRtcRegion(String rtcRegion) {
        this.rtcRegion = rtcRegion;
    }

    public Integer getVideoQualityMode() {
        return videoQualityMode;
    }

    public void setVideoQualityMode(Integer videoQualityMode) {
        this.videoQualityMode = videoQualityMode;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Object getThreadMetadata() {
        return threadMetadata;
    }

    public void setThreadMetadata(Object threadMetadata) {
        this.threadMetadata = threadMetadata;
    }

    public Object getMember() {
        return member;
    }

    public void setMember(Object member) {
        this.member = member;
    }

    public Integer getDefaultAutoArchiveDuration() {
        return defaultAutoArchiveDuration;
    }

    public void setDefaultAutoArchiveDuration(Integer defaultAutoArchiveDuration) {
        this.defaultAutoArchiveDuration = defaultAutoArchiveDuration;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Partial {

        @NotEmpty
        private String id;

        private String name;

        @NotEmpty
        private Integer type; // Channel.Type

        private String permissions;

        @JsonProperty("thread_metadata")
        private Object threadMetadata; // Todo: ThreadMetadata

        @JsonProperty("parent_id")
        private String parentId;

        public Partial() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getPermissions() {
            return permissions;
        }

        public void setPermissions(String permissions) {
            this.permissions = permissions;
        }

        public Object getThreadMetadata() {
            return threadMetadata;
        }

        public void setThreadMetadata(Object threadMetadata) {
            this.threadMetadata = threadMetadata;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }

    public static final class Type {

        public static final int GUILD_TEXT = 0;
        public static final int DM = 1;
        public static final int GUILD_VOICE = 2;
        public static final int GROUP_DM = 3;
        public static final int GUILD_CATEGORY = 4;
        public static final int GUILD_NEWS = 5;
        public static final int GUILD_STORE = 6;
        public static final int GUILD_NEWS_THREAD = 10;
        public static final int GUILD_PUBLIC_THREAD = 11;
        public static final int GUILD_PRIVATE_THREAD = 12;
        public static final int GUILD_STAGE_VOICE = 13;

        private Type() {
        }
    }
}
