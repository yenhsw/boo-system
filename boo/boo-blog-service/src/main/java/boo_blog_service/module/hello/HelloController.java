package boo_blog_service.module.hello;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/secure/test")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Boo!";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Hello from Boo!";
    }

    @GetMapping("/view")
    @PreAuthorize("hasAuthority('USER_VIEW')")
    public String view() {
        return "VIEW_OK";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('USER_CREATE')")
    public String create() {
        return "CREATE_OK";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('USER_UPDATE')")
    public String update() {
        return "UPDATE_OK";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    public String delete() {
        return "DELETE_OK";
    }

    @GetMapping("/system")
    @PreAuthorize("hasAuthority('SYSTEM_MANAGE')")
    public String system() {
        return "SYSTEM_OK";
    }
}