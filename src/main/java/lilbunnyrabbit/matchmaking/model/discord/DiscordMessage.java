package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordMessage {

    @NotEmpty
    private String id;

    @NotEmpty
    @JsonProperty("channel_id")
    private String channelId;

    @JsonProperty("guild_id")
    private String guildId;

    private DiscordUser author;

    private DiscordMember.Partial member;

    @NotEmpty
    private String content;

    @NotEmpty
    private String timestamp;

    @JsonProperty("edited_timestamp")
    private String editedTimestamp;

    @NotEmpty
    private Boolean tts;

    @NotEmpty
    @JsonProperty("mention_everyone")
    private Boolean mentionEveryone;

    private List<DiscordUser.Mention> mentions;

    @JsonProperty("mention_roles")
    private List<String> mentionRoles;

    @JsonProperty("mention_channels")
    private List<DiscordChannel.Mention> mentionChannels;

    @NotEmpty
    private List<DiscordAttachment> attachments;

    @NotEmpty
    private List<DiscordEmbed> embeds;

    private List<DiscordReaction> reactions;

    private String nonce;

    @NotEmpty
    private Boolean pinned;

    @JsonProperty("webhook_id")
    private String webhookId;

    @NotEmpty
    private Integer type; // Message.Type

    private DiscordMessage.Activity activity;

    private DiscordApplication.Partial application;

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("message_reference")
    private DiscordMessage.Reference messageReference;

    private Integer flags;

    @JsonProperty("referenced_message")
    private DiscordMessage referencedMessage;

    private DiscordInteraction interaction;

    private DiscordChannel thread;

    private List<DiscordComponent> components;

    @JsonProperty("sticker_items")
    private List<DiscordSticker.Item> stickerItems;

    private List<DiscordSticker> stickers;

    public DiscordMessage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public DiscordUser getAuthor() {
        return author;
    }

    public void setAuthor(DiscordUser author) {
        this.author = author;
    }

    public DiscordMember.Partial getMember() {
        return member;
    }

    public void setMember(DiscordMember.Partial member) {
        this.member = member;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEditedTimestamp() {
        return editedTimestamp;
    }

    public void setEditedTimestamp(String editedTimestamp) {
        this.editedTimestamp = editedTimestamp;
    }

    public Boolean getTts() {
        return tts;
    }

    public void setTts(Boolean tts) {
        this.tts = tts;
    }

    public Boolean getMentionEveryone() {
        return mentionEveryone;
    }

    public void setMentionEveryone(Boolean mentionEveryone) {
        this.mentionEveryone = mentionEveryone;
    }

    public List<DiscordUser.Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<DiscordUser.Mention> mentions) {
        this.mentions = mentions;
    }

    public List<String> getMentionRoles() {
        return mentionRoles;
    }

    public void setMentionRoles(List<String> mentionRoles) {
        this.mentionRoles = mentionRoles;
    }

    public List<DiscordChannel.Mention> getMentionChannels() {
        return mentionChannels;
    }

    public void setMentionChannels(List<DiscordChannel.Mention> mentionChannels) {
        this.mentionChannels = mentionChannels;
    }

    public List<DiscordAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<DiscordAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<DiscordEmbed> getEmbeds() {
        return embeds;
    }

    public void setEmbeds(List<DiscordEmbed> embeds) {
        this.embeds = embeds;
    }

    public List<DiscordReaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<DiscordReaction> reactions) {
        this.reactions = reactions;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public DiscordApplication.Partial getApplication() {
        return application;
    }

    public void setApplication(DiscordApplication.Partial application) {
        this.application = application;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Reference getMessageReference() {
        return messageReference;
    }

    public void setMessageReference(Reference messageReference) {
        this.messageReference = messageReference;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public DiscordMessage getReferencedMessage() {
        return referencedMessage;
    }

    public void setReferencedMessage(DiscordMessage referencedMessage) {
        this.referencedMessage = referencedMessage;
    }

    public DiscordInteraction getInteraction() {
        return interaction;
    }

    public void setInteraction(DiscordInteraction interaction) {
        this.interaction = interaction;
    }

    public DiscordChannel getThread() {
        return thread;
    }

    public void setThread(DiscordChannel thread) {
        this.thread = thread;
    }

    public List<DiscordComponent> getComponents() {
        return components;
    }

    public void setComponents(List<DiscordComponent> components) {
        this.components = components;
    }

    public List<DiscordSticker.Item> getStickerItems() {
        return stickerItems;
    }

    public void setStickerItems(List<DiscordSticker.Item> stickerItems) {
        this.stickerItems = stickerItems;
    }

    public List<DiscordSticker> getStickers() {
        return stickers;
    }

    public void setStickers(List<DiscordSticker> stickers) {
        this.stickers = stickers;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Partial {
        // TODO
    }

    public static final class Type {

        public static final int DEFAULT = 0;
        public static final int RECIPIENT_ADD = 1;
        public static final int RECIPIENT_REMOVE = 2;
        public static final int CALL = 3;
        public static final int CHANNEL_NAME_CHANGE = 4;
        public static final int CHANNEL_ICON_CHANGE = 5;
        public static final int CHANNEL_PINNED_MESSAGE = 6;
        public static final int GUILD_MEMBER_JOIN = 7;
        public static final int USER_PREMIUM_GUILD_SUBSCRIPTION = 8;
        public static final int USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_1 = 9;
        public static final int USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_2 = 10;
        public static final int USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_3 = 11;
        public static final int CHANNEL_FOLLOW_ADD = 12;
        public static final int GUILD_DISCOVERY_DISQUALIFIED = 14;
        public static final int GUILD_DISCOVERY_REQUALIFIED = 15;
        public static final int GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING = 16;
        public static final int GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING = 17;
        public static final int THREAD_CREATED = 18;
        public static final int REPLY = 19;
        public static final int CHAT_INPUT_COMMAND = 20;
        public static final int THREAD_STARTER_MESSAGE = 21;
        public static final int GUILD_INVITE_REMINDER = 22;
        public static final int CONTEXT_MENU_COMMAND = 23;

        private Type() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Activity {

        @NotEmpty
        private Integer type; // Message.Activity.Type

        @JsonProperty("party_id")
        private String partyId;

        public Activity() {
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getPartyId() {
            return partyId;
        }

        public void setPartyId(String partyId) {
            this.partyId = partyId;
        }

        public static final class Type {

            public static final int JOIN = 1;
            public static final int SPECTATE = 2;
            public static final int LISTEN = 3;
            public static final int JOIN_REQUEST = 5;

            private Type() {
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Reference {

        @JsonProperty("message_id")
        private String messageId;

        @JsonProperty("channel_id")
        private String channelId;

        @JsonProperty("guild_id")
        private String guildId;

        @JsonProperty("fail_if_not_exists")
        private Boolean failIfNotExists;

        public Reference() {
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getGuildId() {
            return guildId;
        }

        public void setGuildId(String guildId) {
            this.guildId = guildId;
        }

        public Boolean getFailIfNotExists() {
            return failIfNotExists;
        }

        public void setFailIfNotExists(Boolean failIfNotExists) {
            this.failIfNotExists = failIfNotExists;
        }
    }
}
