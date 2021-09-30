package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Embed {
    private String title;
    private String type; // TODO: enum
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

    public Embed() {}

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

    public static class Footer {
        private String text;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String icon_url;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String proxy_icon_url;

        public Footer() {}
        public Footer(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getProxy_icon_url() {
            return proxy_icon_url;
        }

        public void setProxy_icon_url(String proxy_icon_url) {
            this.proxy_icon_url = proxy_icon_url;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Image {
        private String url;
        private String proxy_url;
        private String height;
        private String width;

        public Image() {}

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxy_url() {
            return proxy_url;
        }

        public void setProxy_url(String proxy_url) {
            this.proxy_url = proxy_url;
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
        private String url;
        private String proxy_url;
        private String height;
        private String width;

        public Thumbnail() {}

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxy_url() {
            return proxy_url;
        }

        public void setProxy_url(String proxy_url) {
            this.proxy_url = proxy_url;
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
        private String url;
        private String proxy_url;
        private String height;
        private String width;

        public Video() {}

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProxy_url() {
            return proxy_url;
        }

        public void setProxy_url(String proxy_url) {
            this.proxy_url = proxy_url;
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

        public Provider() {}

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
        private String name;
        private String url;
        private String icon_url;
        private String proxy_icon_url;

        public Author() {}

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

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getProxy_icon_url() {
            return proxy_icon_url;
        }

        public void setProxy_icon_url(String proxy_icon_url) {
            this.proxy_icon_url = proxy_icon_url;
        }
    }

    public static class Field {
        private String name;
        private String value;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean inline;

        public Field() {}
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
