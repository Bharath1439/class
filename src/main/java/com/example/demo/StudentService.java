package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;
    public  void addstudentservice(Student student) {
        studentRepository.addstudentdb(student);
    }

    public void addteacherrservice(Teacher teacher) {
        studentRepository.addteacherdb(teacher);
    }

    public void addboth(String teachername, String studentname) {
        studentRepository.addbothdb(teachername,studentname);
    }

    public List<String> getallstudent(String teacher) {
        List<String> list=studentRepository.getallstudentdb(teacher);
        return list;
    }

    public String getteacherbystudent(String student1, String student2, String student3) {
        String teachername=studentRepository.getteacherfromdb(student1,student2,student3);
        return teachername;
    }
}
