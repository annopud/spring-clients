package dev.annopud.spring_clients.first;

import dev.annopud.spring_clients.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spring-clients-service")
public interface FirstFeignClient {

    @GetMapping("/users")
    String findAll();

    @GetMapping("/users/{id}")
    User findById(@PathVariable int id);

}
