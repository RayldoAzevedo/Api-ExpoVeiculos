package br.com.azevedo.rayldo.expo_veiculos.persistence;

import br.com.azevedo.rayldo.expo_veiculos.model.Veiculo;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que estende todas
 * operações básicas do CRUD
 * do Spring Data
 */
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {}

