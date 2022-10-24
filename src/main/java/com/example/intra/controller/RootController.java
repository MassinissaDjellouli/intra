package com.example.intra.controller;
import com.example.intra.dto.BinaryMathOperationDTO;
import com.example.intra.dto.OperationResultDTO;
import com.example.intra.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class RootController {
    private UserService service;

    @PostMapping("/Additionne")
    public ResponseEntity<OperationResultDTO> additionne(@RequestBody BinaryMathOperationDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.additione(dto));
    }
    @PostMapping("/Soustrait")
    public ResponseEntity<OperationResultDTO> soustrait(@RequestBody BinaryMathOperationDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.soustrait(dto));
    }
}
