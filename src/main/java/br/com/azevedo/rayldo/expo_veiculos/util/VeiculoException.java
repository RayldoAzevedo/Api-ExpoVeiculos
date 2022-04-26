package br.com.azevedo.rayldo.expo_veiculos.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe para TRATAMENTO de ERROS DATABASE
 */
public class VeiculoException extends ResponseStatusException {

    public VeiculoException (String msg){
        super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }

}
