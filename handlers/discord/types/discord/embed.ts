export namespace Embed {
  export interface Structure {
    title?: string;
    type?: Type;
    description?: string;
    url?: string;
    timestamp?: string;
    color?: string;
    footer?: Footer;
    image?: Image;
    thumbnail?: Thumbnail;
    video?: Video;
    provider?: Provider;
    author?: Author;
    fields?: Field[];
  }

  export type Type = 'rich' | 'image' | 'video' | 'gifv' | 'article' | 'link';

  export interface Footer {
    text: string;
    icon_url?: string;
    proxy_icon_url?: string;
  }

  export interface Image {
    url?: string;
    proxy_url?: string;
    height?: string;
    width?: string;
  }

  export interface Thumbnail {
    url?: string;
    proxy_url?: string;
    height?: string;
    width?: string;
  }

  export interface Video {
    url?: string;
    proxy_url?: string;
    height?: string;
    width?: string;
  }

  export interface Provider {
    name?: string;
    url?: string;
  }

  export interface Author {
    name?: string;
    url?: string;
    icon_url?: string;
    proxy_icon_url?: string;
  }

  export interface Field {
    name: string;
    value: string;
    inline?: boolean;
  }
}