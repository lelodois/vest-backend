package br.com.lelo.vestibular.auth.domain;

import br.com.lelo.vestibular.auth.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserCommandService command;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        command.save(new User("admin@teste.com.br", "admin", true));
        command.save(new User("user1@teste.com.br", "user1", false));
        command.save(new User("user2@teste.com.br", "user2", false));
    }

}
