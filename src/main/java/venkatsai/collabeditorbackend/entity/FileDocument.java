package venkatsai.collabeditorbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_documents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "file_name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "file_type", nullable = false)
    private String type;

    @NotNull
    @Column(name = "file_size", nullable = false)
    private Long size;

    @NotBlank
    @Column(name = "file_path", nullable = false)
    private String path;

    @NotNull
    @Column(name = "file_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "file_modified_at", nullable = false)
    private LocalDateTime modifiedAt;
}
