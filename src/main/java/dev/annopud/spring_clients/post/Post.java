package dev.annopud.spring_clients.post;

public record Post(
    Integer userId,
    Integer id,
    String title,
    String body
) {
}
