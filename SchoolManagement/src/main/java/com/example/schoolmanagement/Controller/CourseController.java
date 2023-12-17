package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("added Course");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id ,@RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body("update Course");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Course");
    }
    @GetMapping("/check/{id}")
    public ResponseEntity checkTeacher(@PathVariable Integer id){
        courseService.searchTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(courseService.searchTeacher(id));
    }
    @GetMapping("/res/{id}")
    public ResponseEntity restCourse(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listStud(id));

    }

}
