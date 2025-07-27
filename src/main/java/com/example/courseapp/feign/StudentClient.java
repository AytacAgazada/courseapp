package com.example.courseapp.feign;

import com.example.courseapp.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "student-service",url="http://localhost:9091")
public interface StudentClient {

    @GetMapping(value = "api/students/{id}")
    StudentDto getStudentById(Long id);

    @GetMapping(value = "api/student")
    Iterable<StudentDto> getAllStudents();

    @PostMapping
    StudentDto createStudent(@RequestBody StudentDto studentDto);
}
