package lilbunnyrabbit.matchmaking.model.request;

public class VoiceChannelRequest extends ChannelRequest {
    public VoiceChannelRequest() {}
    public VoiceChannelRequest(String name) {
        super(name, 2);
    }
}
