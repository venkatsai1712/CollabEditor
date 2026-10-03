package venkatsai.collabeditorbackend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;
import venkatsai.collabeditorbackend.entity.enums.Privilege;
import venkatsai.collabeditorbackend.entity.enums.SessionUserStatus;


@Entity
@Table(name = "session_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(nullable = false, updatable = false)
    private LocalDateTime joinedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "privilege")
    private Privilege privilege;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SessionUserStatus sessionUserStatus;

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();

        if (sessionUserStatus == null) {
            sessionUserStatus = SessionUserStatus.JOINED;
        }

        if (privilege == null) {
            privilege = Privilege.ALL;
        }
    }
}
