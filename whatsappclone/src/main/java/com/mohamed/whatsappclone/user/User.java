package com.mohamed.whatsappclone.user;

import com.mohamed.whatsappclone.chat.Chat;
import com.mohamed.whatsappclone.common.BaseAuditingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

@NamedQuery(name= UserConstants.FIND_USER_BY_EMAIL,
        query = "select u from User u where u.email=:email"
)

@NamedQuery(name =UserConstants.fIND_ALL_USERS_EXCEPT_SELF,
        query = "select u from User u where u.id!=:publicId"
)

@NamedQuery(name = UserConstants.FIND_USER_BY_PUBLIC_ID ,
        query = "select u from User u where u.id = :publicId"
)
public class User extends BaseAuditingEntity {
    private static final int LAST_ACTIVE_INTERVAL = 5;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastSeen;

    @OneToMany(mappedBy = "sender")
    private List<Chat> chatsASSender;

    @OneToMany(mappedBy = "recipient")
    private List<Chat> chatsASRecipient;

    @Transient
    public boolean isUserOnline(){
        return lastSeen != null && lastSeen.isAfter(LocalDateTime.now().minusMinutes(LAST_ACTIVE_INTERVAL));
    }



}
