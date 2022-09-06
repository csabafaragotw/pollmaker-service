package com.pollmaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/polls")
public class PollController {

    @GetMapping
    public List<PollDto> get() {
        // retrieve all the polls by user
        return List.of(new PollDto("Csaba", "Csaba"), new PollDto("Balazs", "Balazs"));
    }

    @PostMapping
    public PollDto create() {
        // 1. validate user input - RequestBody
        // 2. create database connection first
        // 3. use jdbc to insert line
        // 4. I'd store the questions and answers in single column with the help of json
        return new PollDto("What's your favourite color?", "Yellow");
    }

    @PutMapping("/{id}")
    public PollDto update(@PathVariable String id) {
        // very similar to create endpoint
        return new PollDto("updated" + id, "updated" + id);
    }

    @DeleteMapping("/{id}")
    public PollDto delete(@PathVariable String id) {
        // check if the ownership is correct of the given id
        // use jdbc to delete (soft delete maybe)
        return new PollDto("deleted" + id, "deleted" + id);
    }

}
