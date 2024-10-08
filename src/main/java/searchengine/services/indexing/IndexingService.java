package searchengine.services.indexing;

import org.springframework.stereotype.Service;
import searchengine.dto.indexing.IndexingRequest;
import searchengine.dto.indexing.IndexingResponse;

@Service
public interface IndexingService {
    IndexingResponse startIndexing();

    IndexingResponse stopIndexing();

    IndexingResponse indexPage(IndexingRequest indexingRequest);



}
