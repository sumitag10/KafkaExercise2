package com.example.jpakafka.Controller;

import com.example.jpakafka.Service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/library/{name}")
    public String saveBookName(@PathVariable("name") @NonNull final String name) {
        libraryService.saveBookName(name);
        return "Saved in Database";
    }
}

