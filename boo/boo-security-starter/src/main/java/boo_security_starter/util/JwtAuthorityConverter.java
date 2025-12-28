package boo_security_starter.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtAuthorityConverter {

    private JwtAuthorityConverter() {}

    public static Collection<? extends GrantedAuthority> convert(
            List<String> permissions
    ) {
        return permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}