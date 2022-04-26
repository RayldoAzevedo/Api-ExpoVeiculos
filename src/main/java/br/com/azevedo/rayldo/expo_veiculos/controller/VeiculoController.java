package br.com.azevedo.rayldo.expo_veiculos.controller;

import br.com.azevedo.rayldo.expo_veiculos.model.Veiculo;
import br.com.azevedo.rayldo.expo_veiculos.service.VeiculoService;
import br.com.azevedo.rayldo.expo_veiculos.util.VeiculoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
public class VeiculoController {

    private VeiculoService veiculoService;

    /**
     * Injeção de dependencia do Spring
     * @param veiculoService
     */
    @Autowired
    public void setMedicoService(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    /**
     * Metodo para listagem de veículos
     * @return Lista de Veiculos
     */
    @GetMapping(value = "/listar-veiculos")
    public List<Veiculo> listar(){
        List <Veiculo> lista = veiculoService.listar();

        return lista;
    }

    /**
     * METODO PARA CONSULTAR VEÍCULO
     * @param id
     * @return
     */
    @GetMapping(value = "consultar-veiculo/{id}")
    public Veiculo consultar(@PathVariable Integer id){
        return veiculoService.consultar(id);
    }


    /**
     * Metodo para salvar Veiculo no banco de dados
     * @param TODAS as informações do veiculo recebidas por parametro
     * @return Veiculo
     */
    @PostMapping(value= "incluir-veiculo")
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        try{
            if (veiculo.getIdVeiculo()==null){
                veiculo = veiculoService.incluir(veiculo);
            }
            else{
                veiculoService.alterar(veiculo);
            }
            return veiculo;
        }
        catch (VeiculoException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getReason());
        }
    }


    /**
     * Metodo que exclui usuario pelo id
     * @param id id do usuario a ser excluido
     */
    @DeleteMapping(value = "excluir-veiculo/{id}")
    public void excluir(@PathVariable Integer id){
        veiculoService.excluir(id);
    }

}
