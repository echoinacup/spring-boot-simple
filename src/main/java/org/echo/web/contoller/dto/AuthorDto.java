package org.echo.web.contoller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record AuthorDto(
        @NotBlank(message = "An author needs a full name.")
        @Size(min = 3, max = 35)
        String authorName,
        Set<String> bookTitles) {
}
