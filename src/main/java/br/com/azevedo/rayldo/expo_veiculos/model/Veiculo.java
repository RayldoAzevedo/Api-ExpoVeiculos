package br.com.azevedo.rayldo.expo_veiculos.model;


import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    /**
     * ATRIBUTOS PRIVADOS
     */
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeiculo;

    /**
     *ATRIBUTOS PARA TESTE COM IMAGEM
     */
    @Column(name = "foto")
    private String  foto;
    @Column(name="photo")
    private byte[] photo;
    @Column(name = "iamgem")
    private File image;

    /**
     * DEMAIS ATRIBUTOS
     */
    @Column(name = "propritario")
    private String  proprietario;
    @Column(name = "modelo")
    private String  modelo;
    @Column(name = "marca")
    private String  marca;
    @Column(name = "ano")
    private Date ano;
    @Column(name = "cor")
    private String  cor;
    @Column(name = "categoria")
    private String  Categoria;
    @Column(name = "numerodeportas")
    private int     numeroDePortas;
    @Column(name = "sobre")
    private String  sobre;
    @Column(name = "valorestimado")
    private float   valorEstimado;
    



    /**
     * METODOS PUBLICOS
     *
     */

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }


    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public float getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(float valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

}
