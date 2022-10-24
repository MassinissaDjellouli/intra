package com.example.intra;

import com.example.intra.controller.RootController;
import com.example.intra.dto.BinaryMathOperationDTO;
import com.example.intra.dto.OperationResultDTO;
import com.example.intra.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static   org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
public class RootControllerTest {
    
    MockMvc mockMvc;
    
    @InjectMocks
    RootController rootController;
    
    @Mock
    UserService service;
    
    JacksonTester<BinaryMathOperationDTO> json;
    
    BinaryMathOperationDTO bmoDto;
    OperationResultDTO addResultDTO;
    OperationResultDTO subResultDTO;

    @BeforeEach
    void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(rootController).build();
        bmoDto = BinaryMathOperationDTO.builder().a(4).b(5).build();
        addResultDTO = OperationResultDTO.builder().result(9).build();
        subResultDTO = OperationResultDTO.builder().result(-1).build();
    }
    
    @Test
    public void testAdditionHappyDay() throws Exception {
        when(service.additione(any())).thenReturn(addResultDTO);

        mockMvc.perform(post("/Additionne")
                .content(json.write(bmoDto).getJson())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.result",is(9)));
    }
    @Test
    public void testAdditionNotFound() throws Exception{
        mockMvc.perform(post("/AdditionnePas")
                        .content(json.write(bmoDto).getJson())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void testAdditionBadRequest() throws Exception{
        mockMvc.perform(post("/Additionne"))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testSoustractionHappyDay() throws Exception{
        when(service.soustrait(any())).thenReturn(subResultDTO);

        mockMvc.perform(post("/Soustrait")
                        .content(json.write(bmoDto).getJson())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.result",is(-1)));
    }
    @Test
    public void testSoustractionNotFound() throws Exception{
        mockMvc.perform(post("/SoustraitPas")
                        .content(json.write(bmoDto).getJson())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void testSoustractionBadRequest() throws Exception{
        mockMvc.perform(post("/Soustrait"))
                .andExpect(status().isBadRequest());
    }
}
