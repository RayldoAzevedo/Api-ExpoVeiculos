package br.com.azevedo.rayldo.expo_veiculos.service;

import br.com.azevedo.rayldo.expo_veiculos.model.Veiculo;
import br.com.azevedo.rayldo.expo_veiculos.persistence.VeiculoRepository;
import br.com.azevedo.rayldo.expo_veiculos.util.VeiculoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class VeiculoServiceImpl implements VeiculoService{
    private final VeiculoRepository repository;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository repository) {
        this.repository = repository;
    }

    /**
     * TRATAMENTO DE INFORMAÇÕES PARA METODO DE INCLUSÃO
     * @param veiculo contendo todas as informações coletadas nos campos do usuario
     */
    @Override
    public Veiculo incluir(Veiculo veiculo) {
        try {
            repository.save(veiculo);
            return veiculo;
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível incluir o veículo! :->" + e.getMessage());
        }
    }



    /**
     * TRATAMENTO DE INFORMAÇÕES PARA METODO DE LISTAGEM DE VEICULOS
     *
     */
    @Override
    public List<Veiculo> listar() {
        try {
            return (List<Veiculo>) this.repository.findAll();
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível listar os veículos! :-> " + e.getMessage() );
        }
    }


    /**
     * TRATAMENTO DE INFORMAÇÕES PARA METODO DE COMSULTA DE VEICULOS
     * @param id informando qual veiculo deve ser listado
     */
    @Override
    public Veiculo consultar(Integer id) {
        try {
            return this.repository.findById(id).get();
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível consultar o veiculo: "+id+ " ! :-> " + e.getMessage());
        }
    }

    /**
     * TRATAMENTO DE INFORMAÇÕES PARA METODO QUE ALTERA INFORMAÇÕES DO VEICULO
     * @param veiculo para aplicar as alterações necessárias
     */
    @Override
    public void alterar(Veiculo veiculo) {
        try {
            repository.save(veiculo);
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível alterar o veiculo: " + veiculo.getIdVeiculo() + "! :->" + e.getMessage());
        }
    }

    /**
     * TRATAMENTO DE INFORMAÇÕES PARA METODO DE EXCLUSÃO
     * @param id informando que veiculo deve ser deletado
     */
    @Override
    public void excluir(Integer id) {
        try {
            repository.deleteById(id);
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível excluir o veiculo: "+id+"!");
        }
    }

}
