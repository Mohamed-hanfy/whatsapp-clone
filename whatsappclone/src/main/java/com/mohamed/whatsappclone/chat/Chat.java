package com.mohamed.whatsappclone.chat;

import com.mohamed.whatsappclone.common.BaseAuditingEntity;
import com.mohamed.whatsappclone.messages.Message;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.mohamed.whatsappclone.user.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="chat")
public class Chat extends BaseAuditingEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="recipient_id")
    private User recipient;


    @OneToMany(mappedBy = "chat", fetch = FetchType.EAGER)
    @OrderBy("createdDate DESC")
    private List<Message> messages;
}
