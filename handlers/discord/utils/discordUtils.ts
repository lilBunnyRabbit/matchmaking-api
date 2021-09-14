import { APIGatewayEvent } from 'aws-lambda';
import nacl from 'tweetnacl';

// https://discord.com/developers/docs/interactions/slash-commands#security-and-authorization
export function validDiscordRequest(event: APIGatewayEvent): boolean {
  const signature: any = event.headers?.['X-Signature-Ed25519'] || '';
  const timestamp: any = event.headers?.['X-Signature-Timestamp'] || '';
  const body = event.body;

  return nacl.sign.detached.verify(
    Buffer.from(timestamp + body),
    Buffer.from(signature, 'hex'),
    Buffer.from(process.env.PUBLIC_KEY as any, 'hex')
  );
}

export function safelyParseJson<T>(stringJson: string): T | null {
  if (!stringJson) return null;
  try {
    return JSON.parse(stringJson);
  } catch (e) {
    return null;
  }
}
