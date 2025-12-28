package boo_core.persistence.repository;

import boo_core.persistence.entity.PermissionEntity;
import boo_core.persistence.entity.RoleEntity;
import boo_core.persistence.entity.RolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RolePermissionRepository
        extends JpaRepository<RolePermissionEntity, UUID> {

    @Query("""
        SELECT rp.permission.permissionCode
        FROM RolePermissionEntity rp
        WHERE rp.role IN :roles
    """)
    Set<String> findPermissionCodesByRoles(
            Collection<RoleEntity> roles
    );

    @Query("""
        select rp.permission.permissionCode
        from RolePermissionEntity rp
        where rp.role.roleId = :roleId
    """)
    List<String> findPermissionCodesByRoleId(UUID roleId);
}
