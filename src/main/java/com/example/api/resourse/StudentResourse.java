package com.example.api.resourse;

import com.example.api.Student;
import com.example.api.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentResourse {

    private final StudentService studentService;

    public StudentResourse(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("list")
    public List<Student> list(){
        return studentService.list();
    }

    @PostMapping("item")
    public List<Student> add(@PathVariable Student student){
        studentService.addStudent(student);
        return studentService.list();
    }

    @DeleteMapping("delete/{studentId}")
    public void delete(@PathVariable Long studentId){
        studentService.delete(studentId);
    }

    @PutMapping("item")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }


}
