package boo_security_starter.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint
        implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

//    @Override
//    public void commence(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AuthenticationException ex
//    ) throws IOException {
//
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json");
//
//        objectMapper.writeValue(
//                response.getOutputStream(),
//                ApiResponseUtil.error(ApiResponseCode.UNAUTHORIZED)
//        );
//    }
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException ex
    ) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        Map<String, Object> body = Map.of(
                "code", "UNAUTHORIZED",
                "message", "Authentication required"
        );

        objectMapper.writeValue(response.getOutputStream(), body);
    }

}