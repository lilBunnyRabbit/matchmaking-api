export namespace AllowedMentions {
  export interface Structure {
    parse: Type[];
    roles: string[];
    users: string[];
    replied_user: boolean;
  }

  export type Type = 'roles' | 'users' | 'everyone';
}