package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DInvite implements Serializable {

    @NotEmpty
    private String code;

    private DGuild.Partial guild;

    @NotEmpty
    private DChannel.Partial channel;

    private DUser inviter;

    @JsonProperty("target_type")
    private Integer targetType; // Type

    @JsonProperty("target_user")
    private DUser targetUser;

    @JsonProperty("target_application")
    private DApplication.Partial targetApplication;

    @JsonProperty("approximate_presence_count")
    private Integer approximatePresenceCount;

    @JsonProperty("approximate_member_count")
    private Integer approximateMemberCount;

    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("stage_instance")
    private StageInstance stageInstance;

    public DInvite() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DGuild.Partial getGuild() {
        return guild;
    }

    public void setGuild(DGuild.Partial guild) {
        this.guild = guild;
    }

    public DChannel.Partial getChannel() {
        return channel;
    }

    public void setChannel(DChannel.Partial channel) {
        this.channel = channel;
    }

    public DUser getInviter() {
        return inviter;
    }

    public void setInviter(DUser inviter) {
        this.inviter = inviter;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public DUser getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(DUser targetUser) {
        this.targetUser = targetUser;
    }

    public DApplication.Partial getTargetApplication() {
        return targetApplication;
    }

    public void setTargetApplication(DApplication.Partial targetApplication) {
        this.targetApplication = targetApplication;
    }

    public Integer getApproximatePresenceCount() {
        return approximatePresenceCount;
    }

    public void setApproximatePresenceCount(Integer approximatePresenceCount) {
        this.approximatePresenceCount = approximatePresenceCount;
    }

    public Integer getApproximateMemberCount() {
        return approximateMemberCount;
    }

    public void setApproximateMemberCount(Integer approximateMemberCount) {
        this.approximateMemberCount = approximateMemberCount;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public StageInstance getStageInstance() {
        return stageInstance;
    }

    public void setStageInstance(StageInstance stageInstance) {
        this.stageInstance = stageInstance;
    }

    public String createLink() {
        if (this.code == null) return null;
        return "https://discord.gg/" + this.code;
    }

    public static final class Type {

        public static final int STREAM = 1;
        public static final int EMBEDDED_APPLICATION = 2;

        private Type() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class StageInstance {

        @NotEmpty
        private List<DMember.Partial> members;

        @NotEmpty
        @JsonProperty("participant_count")
        private Integer participantCount;

        @NotEmpty
        @JsonProperty("speaker_count")
        private Integer speakerCount;

        @NotEmpty
        private String topic;

        public StageInstance() {
        }

        public List<DMember.Partial> getMembers() {
            return members;
        }

        public void setMembers(List<DMember.Partial> members) {
            this.members = members;
        }

        public Integer getParticipantCount() {
            return participantCount;
        }

        public void setParticipantCount(Integer participantCount) {
            this.participantCount = participantCount;
        }

        public Integer getSpeakerCount() {
            return speakerCount;
        }

        public void setSpeakerCount(Integer speakerCount) {
            this.speakerCount = speakerCount;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }
    }
}
