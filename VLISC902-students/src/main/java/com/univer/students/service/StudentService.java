package com.univer.students.service;

import com.univer.students.Repository.StudentRepository;
import com.univer.students.model.entity.StudentEntity;
import com.univer.students.model.request.StudentRequest;
import com.univer.students.model.response.StudenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

  public StudenResponse getStudent(Integer id){
      Optional<StudentEntity> entity=
              this.studentRepository.findById(id);
      if(entity.isPresent()) {
          StudenResponse response = new StudenResponse();
          response.setName(entity.get().getName());
          response.setLastName(entity.get().getLastName());
          return response;
      }else{
          return null;
      }
  }
  public StudenResponse savesStudent(StudentRequest request){
      StudentEntity entity=new StudentEntity();
      entity.setName(request.getName());
      entity.setLastName(request.getLastName());
      entity.setCurso(request.getCurso());

      this.studentRepository.save(entity);
      StudenResponse response =new StudenResponse();
      response.setLastName(request.getLastName());

      return response;
  }

}
