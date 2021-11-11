package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.CadastrarContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.ContaPagaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.RespostaCadastroDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.ResumoContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaCadastroDTO cadastrarConta(@RequestBody @Valid CadastrarContaDTO cadastrarContaDTO) {
        Conta conta = modelMapper.map(cadastrarContaDTO, Conta.class);
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(contaService.cadastrarConta(conta), RespostaCadastroDTO.class);

        return respostaCadastroDTO;
    }

    @GetMapping
    public List<ResumoContaDTO> buscarContasCadastradas(@RequestParam(required = false) Status status) {
        List<ResumoContaDTO> listaResumo = new ArrayList<>();

        for (Conta conta : contaService.buscarContasCadastradas(status)) {
            ResumoContaDTO resumo = modelMapper.map(conta, ResumoContaDTO.class);
            listaResumo.add(resumo);
        }
        return listaResumo;

    }

    @PutMapping("/{id}")
    public RespostaCadastroDTO pagarConta(@RequestBody ContaPagaDTO contaPagaDTO, @PathVariable @Valid int id) {
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(contaService.pagarConta(id), RespostaCadastroDTO.class);
        return respostaCadastroDTO;

    }

    @GetMapping("/{id}")
    public Conta pesquisarContaPorId(@PathVariable int id) {
        return contaService.localizarContaPorId(id);
    }


}
