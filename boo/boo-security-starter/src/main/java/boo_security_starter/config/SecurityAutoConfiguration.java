package boo_security_starter.config;

import boo_security_starter.jwt.JwtAccessDeniedHandler;
import boo_security_starter.jwt.JwtAuthenticationEntryPoint;
import boo_security_starter.jwt.JwtAuthenticationFilter;
import boo_security_starter.jwt.JwtTokenProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

//@AutoConfiguration
//@EnableConfigurationProperties(SecurityProperties.class)
//public class SecurityAutoConfiguration {
//}

@AutoConfiguration
@EnableConfigurationProperties(SecurityProperties.class)
@Import({
        JwtAuthenticationFilter.class,
        JwtAuthenticationEntryPoint.class,
        JwtAccessDeniedHandler.class,
        JwtTokenProvider.class
})
public class SecurityAutoConfiguration {
}