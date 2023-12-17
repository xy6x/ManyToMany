package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("added student");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody @Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body("update student");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete student");
    }
    @PutMapping("/{stu_id}/add/{cou_id}")
    public ResponseEntity assignStuToCourse(@PathVariable Integer stu_id, @PathVariable Integer cou_id){
        studentService.assignStudentToCurse(stu_id, cou_id);
        return ResponseEntity.status(HttpStatus.OK).body(" added student in course");
    }
    @PutMapping("{id}/res/{major}")
    public ResponseEntity updateMajor(@PathVariable Integer id ,@PathVariable String major){
        studentService.check(id, major);
        return ResponseEntity.status(HttpStatus.OK).body(" clear");
    }
}
