package lilbunnyrabbit.matchmaking.model.discord;

public class DiscordEmoji {
    public static class Component {
        private String id;
        private String name;
        private Boolean animated;

        public Component(String id, String name, Boolean animated) {
            this.id = id;
            this.name = name;
            this.animated = animated;
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

        public Boolean getAnimated() {
            return animated;
        }

        public void setAnimated(Boolean animated) {
            this.animated = animated;
        }
    }
}
