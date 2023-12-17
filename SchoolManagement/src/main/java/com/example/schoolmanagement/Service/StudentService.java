package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final  StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void updateStudent(Integer id,Student student){
        Student oldStudent=studentRepository.findStudentById(id);
        if (oldStudent == null) {
            throw new ApiException("the student not Found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }
    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("the student not Found");
        }
        studentRepository.delete(student);
    }
    public void  assignStudentToCurse(Integer stu_id,Integer cur_id){
       Student student =studentRepository.findStudentById(stu_id);
        Course course =courseRepository.findCourseById(cur_id);
        if (student == null ||course ==null) {
            throw  new ApiException("this not  fuond ");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
    public void check(Integer id,String major){
        Student student =studentRepository.findStudentById(id);
        if (student != null) {
            student.setMajor(major);
            for (Course a:student.getCourses()
                 ) {
                a.getStudents().remove(student);
                courseRepository.save(a);
            }
           student.setCourses(null);
            studentRepository.save(student);
        }

    }
}
