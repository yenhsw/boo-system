package boo_blog_service.persistence.repository;

import boo_blog_service.persistence.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BlogRepository
        extends JpaRepository<BlogEntity, UUID>,
        JpaSpecificationExecutor<BlogEntity> {
}

