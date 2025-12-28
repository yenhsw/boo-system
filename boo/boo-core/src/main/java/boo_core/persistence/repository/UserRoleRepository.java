package boo_core.persistence.repository;

import boo_core.persistence.entity.RoleEntity;
import boo_core.persistence.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository
        extends JpaRepository<UserRoleEntity, UUID> {

    @Query("""
        SELECT ur.role
        FROM UserRoleEntity ur
        WHERE ur.user.userId = :userId
    """)
    RoleEntity findRoleByUserId(UUID userId);

    Optional<UserRoleEntity> findByUser_UserId(UUID userId);
}
