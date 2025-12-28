package boo_security_starter.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    /**
     * Public endpoints, example:
     * /auth/**
     * /swagger-ui/**
     */
    private List<String> publicUrls = List.of();

    public void setPublicUrls(List<String> publicUrls) {
        System.out.println(">>> SecurityProperties.publicUrls = " + publicUrls);
        this.publicUrls = publicUrls;
    }
}
