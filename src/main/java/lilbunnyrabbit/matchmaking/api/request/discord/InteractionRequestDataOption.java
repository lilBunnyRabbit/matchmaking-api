package lilbunnyrabbit.matchmaking.api.request.discord;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class InteractionRequestDataOption {
    @NotEmpty private String name;
    @NotEmpty private Integer type;
    private String value;
    private List<InteractionRequestDataOption> options;

    public InteractionRequestDataOption() {}

    public static final class Type {
        public static final int SUB_COMMAND = 1;
        public static final int SUB_COMMAND_GROUP = 2;
        public static final int STRING = 3;
        public static final int INTEGER = 4;
        public static final int BOOLEAN = 5;
        public static final int USER = 6;
        public static final int CHANNEL = 7;
        public static final int ROLE = 8;
        public static final int MENTIONABLE = 9;

        private Type() {}
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<InteractionRequestDataOption> getOptions() {
        return options;
    }

    public void setOptions(List<InteractionRequestDataOption> options) {
        this.options = options;
    }
}
