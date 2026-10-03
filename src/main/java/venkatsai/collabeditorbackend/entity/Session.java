package venkatsai.collabeditorbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import venkatsai.collabeditorbackend.entity.enums.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionStatus sessionStatus;

    @OneToMany(mappedBy = "session")
    private List<SessionUser> sessionUsers = new ArrayList<>();

}
