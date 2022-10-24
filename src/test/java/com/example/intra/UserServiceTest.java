package com.example.intra;
import com.example.intra.dto.BinaryMathOperationDTO;
import com.example.intra.dto.OperationResultDTO;
import com.example.intra.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.assertj.core.api.Assertions.assertThat;
public class UserServiceTest {
    @InjectMocks
    UserService service;

    BinaryMathOperationDTO addition;
    OperationResultDTO additionResult;
    BinaryMathOperationDTO soustraction;
    OperationResultDTO soustractionResult;

    @BeforeEach
    void setup(){
        service = new UserService();
        addition = BinaryMathOperationDTO.builder().a(1).b(3).build();
        additionResult = OperationResultDTO.builder().result(4).build();
        soustraction = BinaryMathOperationDTO.builder().a(3).b(1).build();
        soustractionResult = OperationResultDTO.builder().result(2).build();
    }
    @Test
    public void testAdditionneHappyDay(){

        OperationResultDTO additione = service.additione(addition);

        assertThat(additione).isEqualTo(additionResult);
        assertThat(additione.getResult()).isEqualTo(4);
    }

    @Test
    public void testSoustractionHappyDay(){

        OperationResultDTO additione = service.additione(addition);

        assertThat(additione).isEqualTo(additionResult);
        assertThat(additione.getResult()).isEqualTo(4);
    }

}
