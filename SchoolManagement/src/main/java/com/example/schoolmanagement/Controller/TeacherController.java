package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger= LoggerFactory.getLogger(TeacherController.class);

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeacher());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        logger.info("added Teacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("added teacher");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id ,@RequestBody @Valid Teacher teacher){
        logger.info("update Teacher");
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body("update teacher");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        logger.info("delete Teacher");
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete teacher");

    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable Integer id){
        logger.info("search Teacher");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.searchTeacher(id));

    }
    @GetMapping("/check/{number}")
    public ResponseEntity checkTeacher(@PathVariable Integer number){
        logger.info("check Teacher");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.check(number));

    }
    @PutMapping("{teacher_id}/assign/{course_id}")
    public ResponseEntity assign(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(HttpStatus.OK).body("save");

    }
}
