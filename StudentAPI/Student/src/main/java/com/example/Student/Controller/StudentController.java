package com.example.Student.Controller;

import com.example.Student.Entity.StudentEntity;
import com.example.Student.Model.StudentModel;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
     private StudentService studentService;
     @GetMapping("/")
    public ResponseEntity<?> getStudent(){
        List<StudentEntity> studentEntities = studentService.getStudent();
        return new ResponseEntity<>(studentEntities,HttpStatus.OK);
    };
     @PostMapping("/Student")
    public  ResponseEntity<?> addstudent(@RequestBody StudentModel studentModel){
          studentService.addstudent(studentModel);
         return  new ResponseEntity<>("Saved Successfully",HttpStatus.OK);

     }
     @PutMapping("/Student/{id}")
    public ResponseEntity<?> updatestudent(@PathVariable Long id,@RequestBody StudentEntity studentEntity){
         studentService.updatestudent(id,studentEntity);
         return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
     }
     @DeleteMapping("Student/{id}")
    public  ResponseEntity<?> deletestudent(@PathVariable Long id){
         studentService.deletestudent(id);
         return new ResponseEntity<>("Deleted successFully",HttpStatus.OK);
     }
}
