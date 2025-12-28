package boo_core.module.user;


import boo_core.module.user.dto.LoginRequest;
import boo_core.module.user.service.AuthService;
import boo_share.common.response.ApiResponse;
import boo_share.common.response.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<String> login(
            @Valid @RequestBody LoginRequest request
    ) {
        return ApiResponseUtil.success(
                authService.login(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    }
}
