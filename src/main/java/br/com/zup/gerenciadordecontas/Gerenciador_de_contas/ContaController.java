package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.CadastrarContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.RespostaCadastroDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaCadastroDTO cadastrarConta(@RequestBody CadastrarContaDTO cadastrarContaDTO) {
        Conta conta = modelMapper.map(cadastrarContaDTO, Conta.class);
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(contaService.cadastrarConta(conta), RespostaCadastroDTO.class);

        return respostaCadastroDTO;
    }


}
