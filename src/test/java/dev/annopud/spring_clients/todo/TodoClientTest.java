package dev.annopud.spring_clients.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoClientTest {

    @Autowired
    private TodoClient todoClient;

    @Test
    void findAll() {
        List<Todo> todos = todoClient.findAll();
        Assertions.assertThat(todos).hasSize(200);
    }

}