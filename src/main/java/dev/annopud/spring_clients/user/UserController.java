package dev.annopud.spring_clients.user;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRestClient userRestClient;
    // Alternatively, you could use UserHttpClient instead of UserRestClient
    private final UserHttpClient userHttpClient;
    private final DiscoveryClient discoveryClient;

    public UserController(UserRestClient userRestClient, UserHttpClient userHttpClient, DiscoveryClient discoveryClient) {
        this.userRestClient = userRestClient;
        this.userHttpClient = userHttpClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("")
    public String findAll() {
        return "List services by spring clients: " + String.join(", ", discoveryClient.getServices());
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userRestClient.findById(id);
    }

    @GetMapping("/http")
    public List<User> findAllHttp() {
        return userHttpClient.findAll();
    }

    @GetMapping("/http/{id}")
    public User findByIdHttp(@PathVariable int id) {
        return userHttpClient.findById(id);
    }
}
