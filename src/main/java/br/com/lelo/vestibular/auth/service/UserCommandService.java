package br.com.lelo.vestibular.auth.service;

import br.com.lelo.vestibular.auth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class UserCommandService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenCommandService tokenCommandService;

    @Transactional
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public Optional<String> newToken(User user) {

        user = this.userRepository.findByLoginAndPassword(
                user.getLogin(),
                user.getPassword());

        if (user != null) {
            user.setLastLogin(new Date());
            userRepository.save(user);
            return Optional.of(
                    tokenCommandService.generateToken(user));
        }

        return Optional.empty();
    }

    @Transactional
    public User getUser(String token) {
        return userRepository.findByLogin(
                tokenCommandService.extractLogin(token));
    }

}
