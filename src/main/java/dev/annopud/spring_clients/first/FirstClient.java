package dev.annopud.spring_clients.first;

import dev.annopud.spring_clients.user.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("http://spring-clients-service")
public interface FirstClient {

    @GetExchange("/users")
    String findAll();

    @GetExchange("/users/{id}")
    User findById(@PathVariable int id);

}
