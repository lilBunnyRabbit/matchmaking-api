import { Component } from "../../types/discord/component";

function ActionRow(components?: Component.Button.Structure[] | Component.SelectMenu.Structure): Component.ActionRow.Structure {
  return {
    type: Component.Type.ACTION_ROW,
    components: components && (Array.isArray(components) ? components : [components])
  };
}

type ButtonData = Omit<Component.Button.Structure, 'type' | 'style' | 'custom_id'>;
function Button(customId: string, style: Component.Button.Style, data?: ButtonData): Component.Button.Structure {
  return {
    custom_id: customId,
    type: Component.Type.BUTTON,
    style: style,
    ...data
  };
}

type SelectMenuData = Omit<Component.SelectMenu.Structure, 'type' | 'custom_id' | 'options'>;
function SelectMenu(customId: string, options: Component.SelectMenu.Option[], data?: SelectMenuData): Component.SelectMenu.Structure {
  return {
    type: Component.Type.SELECT_MENU,
    custom_id: customId,
    options: options,
    ...data
  };
}

export const DiscordComponent = {
  ActionRow,
  Button: {
    PRIMARY: (id: string, data: ButtonData) => (
      Button(id, Component.Button.Style.PRIMARY, data)
    ),
    SECONDARY: (id: string, data: ButtonData) => (
      Button(id, Component.Button.Style.SECONDARY, data)
    ),
    SUCCESS: (id: string, data: ButtonData) => (
      Button(id, Component.Button.Style.SUCCESS, data)
    ),
    DANGER: (id: string, data: ButtonData) => (
      Button(id, Component.Button.Style.DANGER, data)
    ),
    LINK: (id: string, data: ButtonData) => (
      Button(id, Component.Button.Style.LINK, data)
    )
  },
  SelectMenu
};