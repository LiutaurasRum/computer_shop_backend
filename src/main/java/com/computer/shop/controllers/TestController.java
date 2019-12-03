package com.computer.shop.controllers;

import com.computer.shop.models.Info;
import com.computer.shop.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    InfoRepository infoRepository;

    @PostMapping("/info")
    public Info createNote(@Valid @RequestBody Info info) {
        return infoRepository.save(info);
    }

    @GetMapping("/info")
    public List<Info> getAllNotes() {
        return infoRepository.findAll();
    }
}