package org.echo.persistence.repo;

import org.echo.persistence.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepo extends CrudRepository<Author, Long> {

    @Override
    Optional<Author> findById(Long aLong);
}
