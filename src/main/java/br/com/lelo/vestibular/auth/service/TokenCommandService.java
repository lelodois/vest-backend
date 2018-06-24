package br.com.lelo.vestibular.auth.service;

import br.com.lelo.vestibular.auth.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TokenCommandService {

    public String extractLogin(String token) {
        return JWT.decode(token)
                .getClaim("login")
                .asString();
    }

    public String generateToken(User user) {
        return JWT
                .create()
                .withClaim("login", user.getLogin())
                .withExpiresAt(Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)))
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
