package boo_core.module.user.service;

import boo_security_starter.jwt.JwtTokenProvider;
import boo_share.common.exception.BadRequestException;
import boo_share.common.exception.NotFoundException;
import boo_core.module.user.service.AuthService;
import boo_core.persistence.entity.UserEntity;
import boo_core.persistence.entity.UserRoleEntity;
import boo_core.persistence.repository.RolePermissionRepository;
import boo_core.persistence.repository.UserRepository;
import boo_core.persistence.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RolePermissionRepository rolePermissionRepository;
//    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(String username, String password) {

        UserEntity user = userRepository
                .findByUsername(username)
                .orElseThrow(NotFoundException::new);

        if (!user.isActive()) {
            throw new BadRequestException();
        }

//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new BadRequestException();
//        }

        UserRoleEntity userRole = userRoleRepository
                .findByUser_UserId(user.getUserId())
                .orElseThrow(NotFoundException::new);

        List<String> permissions =
                rolePermissionRepository.findPermissionCodesByRoleId(
                        userRole.getRole().getRoleId()
                );

        return jwtTokenProvider.generateToken(
                user.getUsername(),
                userRole.getRole().getCode(),
                permissions
        );
    }

}
