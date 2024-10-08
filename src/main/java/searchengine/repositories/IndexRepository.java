package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import searchengine.model.Index;
import searchengine.model.Lemma;
import searchengine.model.Page;

import java.util.Set;

public interface IndexRepository extends JpaRepository<Index, Long> {
    int countByLemma(Lemma lemma);

    Set<Index> findAllByLemmaAndPageIn(Lemma lemma, Set<Page> pages);

    Set<Index> findAllByPageAndLemmaIn(Page page, Set<Lemma> lemmas);
}
