package com.example.demo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

     private HashMap<String,Student>  Studentdb;

     private HashMap<String,Teacher> Teacherdb;

     private HashMap<String,List<String>> Studentteacherdb;

    public StudentRepository(HashMap<String, Student> studentdb, HashMap<String, Teacher> teacherdb, HashMap<String, List<String>> studentteacherdb) {
        Studentdb = studentdb;
        Teacherdb = teacherdb;
        Studentteacherdb = studentteacherdb;
    }

    public void addstudentdb(Student student) {
        String name= student.getName();
        Studentdb.put(name,student);
    }

    public void addteacherdb(Teacher teacher) {
        String name=teacher.getName();
        Teacherdb.put(name,teacher);
    }

    public void addbothdb(String teachername, String studentname) {
        List<String> t=new ArrayList<>();
        if(Studentdb.containsKey(studentname) && Teacherdb.containsKey(teachername) ){
            if(Studentteacherdb.containsKey(teachername)){
                Studentteacherdb.get(teachername).add(studentname);
            }
            else{
                t.add(studentname);
                Studentteacherdb.put(teachername,t);
            }
        }
    }
    public List<String> getallstudentdb(String teachername){
        List<String> list=new ArrayList<>();
        if(Studentteacherdb.containsKey(teachername)){
            list=(Studentteacherdb.get(teachername));
        }
        return list;
    }

    public String getteacherfromdb(String student1, String student2, String student3) {
        if(Studentdb.containsKey(student1) && Studentdb.containsKey(student2) && Studentdb.containsKey(student3)){
            for(String x:Studentteacherdb.keySet()){
                List<String> list=Studentteacherdb.get(x);
                if(list.contains(student1) && list.contains(student2) && list.contains(student3)){
                    return x;
                }
            }
        }
        else{
            return "student name is not registered";
        }
        return null;
    }

}
