package br.com.lelo.vestibular.auth.domain;

import br.com.lelo.vestibular.auth.service.UserCommandService;
import br.com.lelo.vestibular.auth.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/auth/")
public class AuthApi {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserQueryService userQueryService;

    @PostMapping
    public User token(@Valid @RequestBody User user) {
        Optional<String> token = userCommandService.newToken(user);
        if (token.isPresent()) {
            user.setToken(token.get());
        }
        return user;
    }

    @PostMapping("user-token/")
    public User getUserByToken(@Valid @RequestBody User userToken) {
        return userCommandService.getUser(userToken.getToken());
    }

    @GetMapping
    public Iterable<User> list() {
        return userQueryService.userFindAll();
    }


}
