package com.example.jpakafka.Service;

import com.example.jpakafka.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {
}
