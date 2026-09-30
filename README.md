# Real-Time Chat Backend — Day 3

A real-time chat backend built with Java 17, Spring Boot, WebSocket/STOMP, PostgreSQL, Redis, JWT and Docker.

## Features
- Registration and login
- BCrypt password hashing
- JWT authentication for REST APIs
- REST message history with pagination
- WebSocket/STOMP real-time messaging
- Typing-indicator topic
- PostgreSQL persistence
- Redis service ready for presence/cache extensions
- Docker Compose
- Swagger/OpenAPI
- Unit test
- GitHub Actions CI

## Run

```bash
docker compose up --build
```

API: http://localhost:8080  
Swagger: http://localhost:8080/swagger-ui.html  
WebSocket endpoint: ws://localhost:8080/ws

## Register

```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"username":"aditya","password":"secret123"}'
```

## Login

```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"aditya","password":"secret123"}'
```

Use the returned token as `Authorization: Bearer YOUR_TOKEN`.

## Message history

```bash
curl http://localhost:8080/api/messages/general?page=0\&size=50 -H "Authorization: Bearer YOUR_TOKEN"
```

## WebSocket/STOMP

Connect to `/ws`, publish to `/app/chat.send`, and subscribe to `/topic/chat/general`.

Example message:
```json
{"chatId":"general","content":"Hello everyone!"}
```

Typing indicator: publish to `/app/chat.typing` and subscribe to `/topic/chat/general/typing`.

## Tests

```bash
mvn test
```

## GitHub upload

Create a public repository named `realtime-chat-java`, then run:

```bash
git init
git add .
git commit -m "feat: build real-time chat backend"
git branch -M main
git remote add origin https://github.com/Vermaaditya3030/realtime-chat-java.git
git push -u origin main
```

## Next improvements
- Authenticate WebSocket CONNECT using JWT
- Redis-backed online presence
- Direct user-to-user destinations
- Group membership and permissions
- Delivered/read states
- Rate limiting
- Redis pub/sub for multiple server instances
- Testcontainers integration tests
