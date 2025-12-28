package boo_core.module.blog.command;

import boo_share.common.exception.NotFoundException;
import boo_core.module.blog.dto.BlogResponse;
import boo_core.module.blog.dto.CreateBlogRequest;
import boo_core.module.blog.dto.UpdateBlogRequest;
import boo_core.module.blog.mapper.BlogMapper;
import boo_core.persistence.entity.BlogEntity;
import boo_core.persistence.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogCommandServiceImpl implements IBlogCommandService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public BlogResponse create(CreateBlogRequest request) {
        BlogEntity entity = new BlogEntity();
        entity.setCode(request.getCode());
        entity.setName(request.getName());

        return blogMapper.toResponse(
                blogRepository.save(entity)
        );
    }

    @Override
    public BlogResponse update(UUID id, UpdateBlogRequest request) {
        BlogEntity entity = blogRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        entity.setName(request.getName());

        return blogMapper.toResponse(entity);
    }

    @Override
    public void delete(UUID id) {
        BlogEntity entity = blogRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        blogRepository.delete(entity);
    }
}