package br.com.azevedo.rayldo.expo_veiculos.service;

import br.com.azevedo.rayldo.expo_veiculos.model.Veiculo;

import java.util.List;

public interface VeiculoService {

    public Veiculo incluir(Veiculo veiculo);
    public List<Veiculo> listar();
    public Veiculo consultar(Integer id);
    public  void alterar(Veiculo veiculo);
    public  void excluir(Integer id);
}
