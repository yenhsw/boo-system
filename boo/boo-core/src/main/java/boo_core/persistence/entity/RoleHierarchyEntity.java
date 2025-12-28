package boo_core.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "role_hierarchy",
        uniqueConstraints = @UniqueConstraint(columnNames = {"parent_role_id", "child_role_id"}))
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleHierarchyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_hierarchy_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_role_id", nullable = false)
    private RoleEntity parentRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_role_id", nullable = false)
    private RoleEntity childRole;
}
