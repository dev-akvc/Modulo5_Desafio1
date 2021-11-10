package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.CadastrarContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.RespostaCadastroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(cadastrarContaDTO, RespostaCadastroDTO.class);
        Conta conta = modelMapper.map(cadastrarContaDTO, Conta.class);
        contaService.cadastrarConta(conta);

        return respostaCadastroDTO;
    }


}
