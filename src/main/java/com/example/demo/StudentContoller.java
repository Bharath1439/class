package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
public class StudentContoller {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudents(@RequestBody Student student){
        studentService.addstudentservice(student);
        return new ResponseEntity<>("student added successfully",HttpStatus.CREATED );
    }

    @PostMapping("/add-teacher")
    public  ResponseEntity<String> addteacher(@RequestBody Teacher teacher){
        studentService.addteacherrservice(teacher);
        return new ResponseEntity<>("Teacher is added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/put-student-teacher")
    public ResponseEntity<String> onetomany(@RequestParam String Teachername,String Studentname){
        studentService.addboth(Teachername,Studentname);
        return new ResponseEntity<>("Teacher is added successfully", HttpStatus.CREATED);
    }
    //here we are getting many students with one teacher name(one to many)
    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = null; // Assign list of student by calling service layer method
        students=studentService.getallstudent(teacher);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    //here we are getting one teacher with many students(many to one)
    @GetMapping("/get-class-based-on student")
    public ResponseEntity<String> getteacherbystudents(@PathVariable String student1,String student2,String student3){
        String teachername=studentService.getteacherbystudent(student1,student2,student3);
        return new ResponseEntity<>(teachername, HttpStatus.CREATED);
    }

}
