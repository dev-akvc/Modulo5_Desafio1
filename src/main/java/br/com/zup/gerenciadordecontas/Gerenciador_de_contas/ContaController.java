package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.CadastrarContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.ContaPagaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.RespostaCadastroDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos.ResumoContaDTO;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.StatusInvalidoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
@Api(value = "Gerenciador_de_contas")
@CrossOrigin(origins = "*")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Método utilizado para cadastrar uma conta")
    public RespostaCadastroDTO cadastrarConta(@RequestBody @Valid CadastrarContaDTO cadastrarContaDTO) {
        Conta conta = modelMapper.map(cadastrarContaDTO, Conta.class);
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(contaService.cadastrarConta(conta), RespostaCadastroDTO.class);

        return respostaCadastroDTO;
    }

    @GetMapping
    @ApiOperation(value = "Método utilizado para listar contas cadastradas")
    public List<ResumoContaDTO> buscarContasCadastradas(@RequestParam(required = false) Status status,
                                                        @RequestParam(required = false) Tipo tipo,
                                                        @RequestParam(required = false) Double valor) {
        List<ResumoContaDTO> listaResumo = new ArrayList<>();

        for (Conta conta : contaService.buscarContasCadastradas(status, tipo, valor)) {
            ResumoContaDTO resumo = modelMapper.map(conta, ResumoContaDTO.class);
            listaResumo.add(resumo);
        }
        return listaResumo;

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Método utilizado para registrar pagamento de uma conta")
    public RespostaCadastroDTO pagarConta(@RequestBody ContaPagaDTO contaPagaDTO, @PathVariable int id) {
        if (contaPagaDTO.getStatus() != Status.PAGO) {
            throw new StatusInvalidoException("Deve ser informado status: PAGO");
        }
        RespostaCadastroDTO respostaCadastroDTO = modelMapper.map(contaService.pagarConta(id), RespostaCadastroDTO.class);
        return respostaCadastroDTO;

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Método utilizado para listar uma conta específica")
    public Conta pesquisarContaPorId(@PathVariable int id) {
        return contaService.localizarContaPorId(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Método utilizado para apagar uma conta específica")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable int id) {
        contaService.deletarConta(id);
    }

}
