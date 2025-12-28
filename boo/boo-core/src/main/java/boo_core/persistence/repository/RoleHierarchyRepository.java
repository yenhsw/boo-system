package boo_core.persistence.repository;

import boo_core.persistence.entity.RoleEntity;
import boo_core.persistence.entity.RoleHierarchyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RoleHierarchyRepository
        extends JpaRepository<RoleHierarchyEntity, UUID> {

    @Query("""
        SELECT rh.childRole
        FROM RoleHierarchyEntity rh
        WHERE rh.parentRole = :parent
    """)
    List<RoleEntity> findChildren(RoleEntity parent);

    @Query("""
        select rh.childRole.roleId
        from RoleHierarchyEntity rh
        where rh.parentRole.roleId = :parentRoleId
    """)
    List<UUID> findChildRoleIds(UUID parentRoleId);
}
