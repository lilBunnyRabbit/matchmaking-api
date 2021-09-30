package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordEmbed {

    private String title;

    private String type; // Type

    private String description;

    private String url;

    private String timestamp;

    private Integer color;

    private Footer footer;

    private Image image;

    private Thumbnail thumbnail;

    private Video video;

    private Provider provider;

    private Author author;

    private List<Field> fields;

    public DiscordEmbed() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void setFields(Field... fields) {
        this.fields = List.of(fields);
    }

    public static final class Type {

        public static final String RICH = "rich";
        public static final String IMAGE = "image";
        public static final String VIDEO = "video";
        public static final String GIFV = "gifv";
        public static final String ARTICLE = "article";
        public static final String LINK = "link";

        private Type() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Footer {

        @NotEmpty
        private String text;

        @JsonProperty("icon_url")
        private String iconUrl;

        @JsonProperty("proxy_icon_url")
        private String proxyIconUrl;

        public Footer() {
        }

        public Footer(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getProxyIconUrl() {
            return proxyIconUrl;
        }

        public void setProxyIconUrl(String proxyIconUrl) {
            this.proxyIconUrl = proxyIconUrl;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Image {

        @NotEmpty
        private String url;

        @JsonProperty("proxy_url")
        private String proxyUrl;

        private String height;

        private String width;

        public Image() {
        }

        public Image(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxyUrl() {
            return proxyUrl;
        }

        public void setProxyUrl(String proxyUrl) {
            this.proxyUrl = proxyUrl;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Thumbnail {

        @NotEmpty
        private String url;

        @JsonProperty("proxy_url")
        private String proxyUrl;

        private String height;

        private String width;

        public Thumbnail() {
        }

        public Thumbnail(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxyUrl() {
            return proxyUrl;
        }

        public void setProxyUrl(String proxyUrl) {
            this.proxyUrl = proxyUrl;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Video {

        @NotEmpty
        private String url;

        @JsonProperty("proxy_url")
        private String proxyUrl;

        private String height;

        private String width;

        public Video() {
        }

        public Video(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxyUrl() {
            return proxyUrl;
        }

        public void setProxyUrl(String proxyUrl) {
            this.proxyUrl = proxyUrl;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Provider {

        private String name;

        private String url;

        public Provider() {
        }

        public Provider(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Author {

        @NotEmpty
        private String name;

        private String url;

        @JsonProperty("icon_url")
        private String iconUrl;

        @JsonProperty("proxy_icon_url")
        private String proxyIconUrl;

        public Author() {
        }

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getProxyIconUrl() {
            return proxyIconUrl;
        }

        public void setProxyIconUrl(String proxyIconUrl) {
            this.proxyIconUrl = proxyIconUrl;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Field {

        @NotEmpty
        private String name;

        @NotEmpty
        private String value;

        private Boolean inline;

        public Field() {
        }

        public Field(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Boolean getInline() {
            return inline;
        }

        public void setInline(Boolean inline) {
            this.inline = inline;
        }
    }
}
