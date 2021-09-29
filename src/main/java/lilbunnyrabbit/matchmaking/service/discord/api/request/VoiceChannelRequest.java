package lilbunnyrabbit.matchmaking.service.discord.api.request;

public class VoiceChannelRequest extends ChannelRequest {
    public VoiceChannelRequest() {}
    public VoiceChannelRequest(String name) {
        super(name, 2);
    }
}
