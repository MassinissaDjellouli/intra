package com.example.intra.service;

import com.example.intra.dto.BinaryMathOperationDTO;
import com.example.intra.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public OperationResultDTO additione(BinaryMathOperationDTO binaryMathOperationDTO) {
        return OperationResultDTO
                .builder()
                .result(binaryMathOperationDTO.getA() + binaryMathOperationDTO.getB())
                .build();
    }
    public OperationResultDTO soustrait(BinaryMathOperationDTO binaryMathOperationDTO){
        return OperationResultDTO
                .builder()
                .result(binaryMathOperationDTO.getA() - binaryMathOperationDTO.getB())
                .build();

    }
}
