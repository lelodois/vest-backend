package br.com.lelo.vestibular.auth.service;

import br.com.lelo.vestibular.auth.domain.User;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
interface UserRepository extends Repository<User, Long> {

    User save(User user);

    List<User> findAll();

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);
}
