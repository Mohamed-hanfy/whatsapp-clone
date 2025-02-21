# WhatsApp Clone

## Overview

A scalable, real-time messaging platform leveraging Spring Boot, Keycloak for authentication, and WebSocket for seamless interactions. This system integrates core chat functionalities, ensuring a secure and responsive communication experience.

## Key Features

- **Instant Messaging**: Real-time text and media exchange
- **Secure Authentication**: Keycloak-powered OAuth2/JWT authentication
- **Live Notifications**: WebSocket-driven updates
- **Media Sharing**: Support for multimedia messaging
- **Delivery Status**: Message state tracking (SENT/SEEN)
- **User Presence**: Online/offline indicators

## Architectural Overview

The application is structured into distinct layers ensuring modularity and maintainability:

```
                 ┌─────────────────┐
                 │ Authentication  │
                 └────────┬────────┘
                          │
                          ▼
┌─────────────┐    ┌───────────────┐    ┌─────────────┐
│ WebSocket   │◄───┤    API        ├───►│  Database   │
│ (Real-time) │    │ Controllers   │    │ Repository  │
└─────────────┘    └───────────────┘    └─────────────┘
                           │
       ┌───────────────────┼───────────────────┐
       ▼                   ▼                   ▼
┌─────────────┐    ┌─────────────┐     ┌─────────────┐
│  Chat       │    │  Message    │     │    User     │
│  Service    │    │  Service    │     │   Service   │
└─────────────┘    └─────────────┘     └─────────────┘
```

### Core Components

1. **Security Layer**: OAuth2/JWT authentication via Keycloak
2. **REST API**: Endpoint management for chat, users, and messages
3. **WebSocket Layer**: Real-time updates and notifications
4. **Business Logic**: Service layer for core functionality
5. **Data Persistence**: JPA repositories for structured data access
6. **Utilities**: Cross-cutting concerns like request interceptors and file handling

## Project Structure

Organized into modular packages, each handling a distinct domain:

```
com.example.whatsappclone
├── chat       # Chat service implementation
├── common     # Shared utilities and base classes
├── file       # Media file handling
├── interceptor # Request filters and synchronization
├── messages   # Messaging domain logic
├── notification # Notification system
├── security   # Authentication and authorization setup
├── user       # User management
├── ws         # WebSocket configuration
└── Application.java # Main application entry point
```

## Getting Started

### Prerequisites

- Java 17+
- Docker & Docker Compose
- Maven 3.8+
- Git

### Installation

```bash
git clone https://github.com/yourusername/whatsapp-clone.git
cd whatsapp-clone
```

Create `application.yml` with necessary configurations, then run:

```bash
./mvnw spring-boot:run
```

## API Documentation
### Chat Endpoints

- `GET /api/v1/chats` - Get all chats for current user
- `POST /api/v1/chats?sender-id={senderId}&receiver-id={receiverId}` - Create new chat

### Message Endpoints

- `GET /api/v1/messages/chat/{chat-id}` - Get all messages in a chat
- `POST /api/v1/messages` - Send new text message
- `POST /api/v1/messages/upload-media?chat-id={chatId}` - Upload and send media message
- `PATCH /api/v1/messages?chat-id={chatId}` - Mark messages as seen

### User Endpoints

- `GET /api/v1/users` - Get all users

### Models

#### Message Types

- `TEXT` - Text messages
- `IMAGE` - Image files
- `AUDIO` - Audio recordings
- `VIDEO` - Video files

#### Message States

- `SENT` - Message delivered to server
- `SEEN` - Message viewed by recipient

### Security

All endpoints require JWT authentication:

```bash
Authorization: Bearer <token>
```

## Deployment

### Automated Deployment Script

Give execution permission to the script and run it:

```bash
chmod +x deploy.sh
./deploy.sh
```

## License

This project is licensed under the MIT License - see the [LICENSE](https://chatgpt.com/c/LICENSE) file for details.
