package boo_blog_service.blog;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs/test")
public class BlogTestController {

    @GetMapping("/public")
    public String publicApi() {
        return "PUBLIC_OK";
    }

    @GetMapping("/secure")
    @PreAuthorize("hasAuthority('BLOG_VIEW')")
    public String secureApi() {
        return "SECURE_OK";
    }
}
