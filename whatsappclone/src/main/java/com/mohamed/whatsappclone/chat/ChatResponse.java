package com.mohamed.whatsappclone.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    private String id;
    private String name;
    private Long unreadCount;
    private String lastMessage;
    private String lastMessageTime;
    private boolean isRecipientOnline;
    private String senderId;
    private String receiverId;

}
