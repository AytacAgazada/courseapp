package com.example.courseapp.controller;

import com.example.courseapp.dto.CourseDto;
import com.example.courseapp.dto.StudentDto;
import com.example.courseapp.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public CourseDto create(@RequestBody CourseDto studentDto){
        return courseService.create(studentDto);
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable Long id){
        return courseService.getById(id);
    }

    @GetMapping
    public Iterable<CourseDto> getAll(){
        return courseService.getAll();
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable Long id,@RequestBody CourseDto courseDto){
        return courseService.update(id,courseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return courseService.getStudentById(id);
    }
    @GetMapping("/student")
    public Iterable<StudentDto> getAllStudents(){
        return courseService.getAllStudents();
    }
    @PostMapping("/student")
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return courseService.createStudent(studentDto);
    }

}
