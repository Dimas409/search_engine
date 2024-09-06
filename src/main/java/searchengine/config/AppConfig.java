package searchengine.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "config")
public class AppConfig {
    private String agent;
    private String referrer;
    private int timeoutMin;
    private int timeoutMax;
    private List<SiteProps> sites;

}
