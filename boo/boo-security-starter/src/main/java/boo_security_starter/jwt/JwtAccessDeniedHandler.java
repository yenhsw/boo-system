package boo_security_starter.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAccessDeniedHandler
        implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

//    @Override
//    public void handle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AccessDeniedException ex
//    ) throws IOException {
//
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        response.setContentType("application/json");
//
//        objectMapper.writeValue(
//                response.getOutputStream(),
//                ApiResponseUtil.error(ApiResponseCode.FORBIDDEN)
//        );
//    }
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException ex
    ) throws IOException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        Map<String, Object> body = Map.of(
                "code", "FORBIDDEN",
                "message", "Access is denied"
        );

        objectMapper.writeValue(response.getOutputStream(), body);
    }

}
