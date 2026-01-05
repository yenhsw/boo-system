package boo_security_starter.util;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public final class SecurityUtil {

    private SecurityUtil() {}

    public static UUID getCurrentUserId() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            throw new IllegalStateException("Unauthenticated");
        }


        var principal = auth.getPrincipal();

        if (principal instanceof JwtUserPrincipal user) {
            return user.getUserId();
        }

        throw new IllegalStateException("Invalid principal");
    }
}
