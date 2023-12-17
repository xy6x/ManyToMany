package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private  final CourseRepository courseRepository;
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher == null) {
            throw new ApiException("the teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if ( teacher == null) {
            throw new ApiException("the teacher not found");
        }
        teacherRepository.delete(teacher);
    }
    public Teacher searchTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if ( teacher == null) {
            throw new ApiException("the teacher not found");
        }
        return teacher;
    }
    public Address check(Integer number){
        Address address=addressRepository.findAddressById(number);
        if ( address == null) {
            throw new ApiException("the teacher not found");
        }
        return address;
    }
    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher =teacherRepository.findTeacherById(teacher_id);
        Course course =courseRepository.findCourseById(course_id);
        if (course == null|| teacher == null) {
            throw new ApiException(" the course or teacher not found");
        }
        course.setTeach(teacher);
        courseRepository.save(course);

    }
}
