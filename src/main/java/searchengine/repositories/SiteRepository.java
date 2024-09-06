package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import searchengine.model.Site;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    Set<Site> findAllByStatus(Site.Status status);

    boolean existsByStatus(Site.Status status);

    boolean existsByIdAndStatus(Long id, Site.Status status);

    Optional<Site> findByUrlIgnoreCase(String url);

    boolean existsByStatusNot(Site.Status status);
}
