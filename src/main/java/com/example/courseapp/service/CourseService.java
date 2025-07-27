package com.example.courseapp.service;

import com.example.courseapp.dto.CourseDto;
import com.example.courseapp.dto.StudentDto;

import java.util.List;

public interface CourseService {

    CourseDto create(CourseDto courseDto);
    List<CourseDto> getAll();
    CourseDto update(Long id,CourseDto courseDto);
    CourseDto getById(Long id);
    void delete(Long id);

    StudentDto getStudentById(Long id);
    Iterable<StudentDto> getAllStudents();
    StudentDto createStudent(StudentDto studentDto);
}
