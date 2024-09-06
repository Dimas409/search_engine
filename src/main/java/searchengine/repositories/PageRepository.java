package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import searchengine.model.Page;
import searchengine.model.Site;

import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    boolean existsBySiteIdAndPath(Long siteId, String path);

    long countBySite(Site site);

    Optional<Page> findBySiteAndPath(Site site, String path);

}
