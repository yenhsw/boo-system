package boo_security_starter.jwt;

import boo_security_starter.config.SecurityProperties;
import boo_security_starter.util.JwtAuthorityConverter;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final SecurityProperties securityProperties;

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) {
//        String path = request.getRequestURI();
//
//        return securityProperties.getPublicUrls()
//                .stream()
//                .anyMatch(pattern -> pathMatcher.match(pattern, path));
//    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();

        boolean skip = securityProperties.getPublicUrls()
                .stream()
                .anyMatch(pattern -> pathMatcher.match(pattern, path));

        System.out.println(
                ">>> JwtAuthenticationFilter | path=" + path + " | skip=" + skip
        );

        return skip;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            Claims claims = tokenProvider.parseToken(header.substring(7));

            List<String> permissions = claims.get("permissions", List.class);

            var authorities = JwtAuthorityConverter.convert(permissions);

            var authentication = new UsernamePasswordAuthenticationToken(
                    claims.getSubject(),
                    null,
                    authorities
            );

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}