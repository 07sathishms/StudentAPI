package com.example.Student.Service;

import com.example.Student.Entity.StudentEntity;
import com.example.Student.Model.StudentModel;
import com.example.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<StudentEntity> getStudent() {
        List<StudentEntity> s = studentRepository.findAll();
        return  s;
    }

    public StudentEntity addstudent(@RequestBody StudentModel studentModel) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setDepartment(studentModel.getDepartment());
        studentEntity.setEmail(studentModel.getEmail());
        studentEntity.setName(studentModel.getName());
        studentRepository.save(studentEntity);
        return  studentEntity;
    };

    public void updatestudent(Long id, StudentEntity studentEntity) {
        StudentEntity studentEntity1 = studentRepository.getReferenceById(id);
        studentEntity1.setName(studentEntity.getName());
        studentEntity1.setEmail(studentEntity.getEmail());
        studentEntity1.setDepartment(studentEntity.getDepartment());
        studentRepository.save(studentEntity1);
    }

    public void deletestudent(Long id) {
        studentRepository.deleteById(id);
    }
}
