package com.resttemplate.RestTemplateController;

import com.resttemplate.DTO.StudentDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    RestTemplate restTemplate = new RestTemplate();
    String urlGet = "http://localhost:8080/api/v1/students";

    @GetMapping()
    public ResponseEntity<String> findAll(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlGet,String.class);
        return responseEntity;
    }

    @PostMapping()
    public ResponseEntity<StudentDto> save(){
        StudentDto studentDto = new StudentDto((long) 9,"Tung");
        ResponseEntity<StudentDto> result = restTemplate.postForEntity(urlGet,studentDto,StudentDto.class);
        return result;
    }
}
