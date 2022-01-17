package com.labtwin.raghu.tictactoespringrs;

import com.labtwin.raghu.tictactoespringrs.vo.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Optional<Object> findById(Long valueOf) {
        return Optional.ofNullable(valueOf);
        // return Optional.of(valueOf).orElseGet(createUser());
    }
}
