package searchengine.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "page", indexes = @javax.persistence.Index(columnList = "path"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"site_id", "path"}))
public class Page {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false, columnDefinition = "BIGINT")
    private Site site;

    @Column( nullable = false, columnDefinition = "VARCHAR(511)")
    private String path;

    @Column(nullable = false, columnDefinition = "INT")
    private Integer code;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    @ToString.Exclude
    private String content;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    private Set<Index> indices = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(site, page.site) && Objects.equals(path, page.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, path);
    }
}
