package searchengine.dto.statistics;

import lombok.Data;

public record StatisticsResponse(boolean result, StatisticsData statistics) {
    public StatisticsResponse(StatisticsData statistics) {
        this(true, statistics);
    }
}
