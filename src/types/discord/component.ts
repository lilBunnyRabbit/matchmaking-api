export namespace Component {
  export interface Structure {
    type: Type;
    custom_id?: string;
    disabled?: boolean;
    style?: Button.Style;
    label?: string;
    emoji?: any; // TODO: with Emoji object
    url?: string;
    options?: SelectMenu.Option[];
    placeholder?: string;
    min_values?: number;
    max_values?: number;
    components?: Component.Structure[];
  }

  export enum Type {
    ACTION_ROW = 1,
    BUTTON = 2,
    SELECT_MENU = 3
  }

  // max 5
  export namespace ActionRow {
    export interface Structure {
      type: Component.Type.ACTION_ROW;
      components?: Button.Structure[] | SelectMenu.Structure[];
    }
  }

  // max 5
  export namespace Button {
    export interface Structure extends Pick<Component.Structure, 'style' | 'label' | 'emoji' | 'custom_id' | 'url' | 'disabled'> {
      type: Component.Type.BUTTON;
    }

    export enum Style {
      PRIMARY = 1,
      SECONDARY = 2,
      SUCCESS = 3,
      DANGER = 4,
      LINK = 5
    }
  }

  export namespace SelectMenu {
    export interface Structure extends Pick<Component.Structure, 'options' | 'placeholder' | 'min_values' | 'max_values' | 'disabled'> {
      type: Component.Type.SELECT_MENU;
      custom_id: string;
    }

    export interface Option {
      label: string;
      value: string;
      description?: string;
      emoji?: any; // TODO: with Emoji object
      default?: boolean;
    }
  }
}