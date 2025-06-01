package dev.annopud.spring_clients.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class PostClient {

    private final RestClient restClient;

    public PostClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
    }

    public List<Post> findAll() {
        return restClient.get()
            .uri("/posts")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
    }
}
