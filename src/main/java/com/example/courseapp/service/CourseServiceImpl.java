package com.example.courseapp.service;

import com.example.courseapp.dto.CourseDto;
import com.example.courseapp.dto.StudentDto;
import com.example.courseapp.entity.Course;
import com.example.courseapp.feign.StudentClient;
import com.example.courseapp.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentClient studentClient;

    @Override
    public CourseDto create(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setAddress(courseDto.getAddress());
        return new CourseDto(courseRepo.save(course).getId(),course.getName(),course.getAddress());
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepo.findAll().stream()
                .map(c -> new CourseDto(c.getId(),c.getName(),c.getAddress()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto update(Long id,CourseDto courseDto) {
        Course course = courseRepo.findById(id)
                        .orElseThrow(()->new RuntimeException("Course not found"));
        course.setName(courseDto.getName());
        course.setAddress(courseDto.getAddress());
        return new CourseDto(courseRepo.save(course).getId(),course.getName(),course.getAddress());
    }

    @Override
    public CourseDto getById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Course not found"));
        return new CourseDto(course.getId(),course.getName(),course.getAddress());
    }

    @Override
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }


    @Override
    public StudentDto getStudentById(Long id) {
        return studentClient.getStudentById(id);
    }

    @Override
    public Iterable<StudentDto> getAllStudents() {
        return studentClient.getAllStudents();
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        return studentClient.createStudent(studentDto);
    }
}
