package br.com.azevedo.rayldo.expo_veiculos.service;

import br.com.azevedo.rayldo.expo_veiculos.model.Veiculo;
import br.com.azevedo.rayldo.expo_veiculos.persistence.VeiculoRepository;
import br.com.azevedo.rayldo.expo_veiculos.util.VeiculoException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
@Transactional
public class VeiculoServiceImpl implements VeiculoService{
    private final VeiculoRepository repository;


    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

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

            public uploadFile(veiculo.getImage());

            repository.save(veiculo);
            return veiculo;
        }
        catch (Exception e){
            throw new VeiculoException("Não foi possível incluir o veículo! :->" + e.getMessage());
        }
    }

    /**
     * METODO CRIADO PARA ENVIO DE IAMGEM PARA AWS STORAGE
     * @param multipartFile
     * @return
     */
    private URI uploadFile(MultipartFile multipartFile) {

        try {

            String fileName = multipartFile.getOriginalFilename();
            InputStream is = null;  is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();

            return uploadFile(is, fileName, contentType);
        } catch (IOException e) {
            throw new RuntimeException("Erro de IO" + e.getMessage());
        }
    }

    /**
     * AWS STORAGE ADD IAMGE
     * @param is
     * @param fileName
     * @param contentType
     * @return
     */
    public URI uploadFile(InputStream is, String fileName, String contentType){
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(contentType);

        s3client.putObject(new PutObjectRequest(bucketName, fileName, is, meta));

        try {
            return s3client.getUrl(bucketName, fileName).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException( "Erro na conveção da URL");
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
