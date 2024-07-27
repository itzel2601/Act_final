package com.univer.students.controller;

import com.univer.students.Repository.StudentRepository;
import com.univer.students.model.entity.StudentEntity;
import com.univer.students.model.request.StudentRequest;
import com.univer.students.model.response.StudenResponse;
import com.univer.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentRestController {
@Autowired
private StudentService StudentService;
    @GetMapping("api/univer/estudiante/{id}")
    public ResponseEntity studiante(@PathVariable String id){
        StudenResponse response = this.StudentService.getStudent(Integer.parseInt(id));
        if(response != null) {

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity("No se tiene registros de ese ID",HttpStatus.NO_CONTENT);
        }
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/api/univer/estudiante")
    public ResponseEntity guardado (@RequestBody StudentRequest request){

        StudenResponse response = this.StudentService.savesStudent(request);

        return new ResponseEntity (response , HttpStatus.CREATED);
    }
}
