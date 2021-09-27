# matchmaking-api
## Config
`application-*.properties`
```yaml
server.port={PORT}
spring.datasource.url=jdbc:postgresql://{DB_HOST}:{DB_PORT}/{DB_NAME}
spring.datasource.username={DB_USERNAME}
spring.datasource.password={DB_PASSWORD}
```

`discord.properties`
```yaml
publicKey={APP_PUBLIC_KEY}
```