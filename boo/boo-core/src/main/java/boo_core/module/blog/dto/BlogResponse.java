package boo_core.module.blog.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class BlogResponse {
    private UUID id;
    private String code;
    private String name;
}