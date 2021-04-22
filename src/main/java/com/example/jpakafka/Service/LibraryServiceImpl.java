package com.example.jpakafka.Service;

import com.example.jpakafka.model.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryServiceImpl.class);

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void saveBookName(String name) {
        Library library = new Library();
        library.setText(name);
        Library library1 = libraryRepository.save(library);
        LOGGER.info("{} is saved in database",name);
    }
}
