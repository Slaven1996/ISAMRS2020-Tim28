package com.ServisKlinickihCentara.controller;


import com.ServisKlinickihCentara.dto.MessageDTO;
import com.ServisKlinickihCentara.dto.typeOfExamDTO.TypeOfExamDTO;
import com.ServisKlinickihCentara.service.TypeOfExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/typeOfExam")
public class TypeOfExamController {

    @Autowired
    private TypeOfExamService typeOfExamService;

    @RequestMapping(value = "/getTypeOfExams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<String>> getTypeOfExams(){
        ArrayList<String> names = typeOfExamService.getTypeOfExams();
        return new ResponseEntity<ArrayList<String>>(names, HttpStatus.OK);

    }

    @RequestMapping(value = "/getTypeOfExamsWithoutOperations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<String>> getTypeOfExamsWithoutOperations(){
        ArrayList<String> names = typeOfExamService.getTypeOfExamsWithoutOperations();
        return new ResponseEntity<ArrayList<String>>(names, HttpStatus.OK);

    }

    @RequestMapping(value = "/addNewTypeOfExam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> addNewTypeOfExam(@RequestBody TypeOfExamDTO typeOfExamDTO){
        MessageDTO messageDTO = typeOfExamService.addNewTypeOfExam(typeOfExamDTO);
        return new ResponseEntity<MessageDTO>(messageDTO, HttpStatus.OK);

    }

}
