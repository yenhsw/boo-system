package boo_core.persistence.repository;

import boo_core.persistence.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BlogRepository
        extends JpaRepository<BlogEntity, UUID>,
        JpaSpecificationExecutor<BlogEntity> {
}

