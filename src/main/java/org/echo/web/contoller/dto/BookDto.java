package org.echo.web.contoller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookDto(
        @NotBlank(message = "Your book needs a title.")
        @Size(min = 3, max = 150)
        String title,
        @NotBlank(message = "Your book needs an author.")
        @Size(min = 3, max = 150)
        String authorName) {
}
