package br.com.maryexames.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cep;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "estado_civil")
    private String estadoCivil;

    private Integer idade;

    @Column(name = "quantidade_filhos")
    private Integer quantidadeFilhos;

    @Column(name = "cliente_mary_card")
    private Boolean clienteMaryCard;

    private String telefone;

    private String email;

    @Column(name = "tem_dependentes")
    private Boolean temDependentes;

    @Column(name = "dependente_1")
    private String dependente1;

    @Column(name = "dependente_2")
    private String dependente2;

    @Column(name = "dependente_3")
    private String dependente3;

    @Column(name = "dependente_4")
    private String dependente4;

    @Column(name = "dependente_5")
    private String dependente5;

    private byte[] biometria;

    @Column(name = "imagem_facial")
    private byte[] imagemFacial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getQuantidadeFilhos() {
        return quantidadeFilhos;
    }

    public void setQuantidadeFilhos(Integer quantidadeFilhos) {
        this.quantidadeFilhos = quantidadeFilhos;
    }

    public Boolean getClienteMaryCard() {
        return clienteMaryCard;
    }

    public void setClienteMaryCard(Boolean clienteMaryCard) {
        this.clienteMaryCard = clienteMaryCard;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTemDependentes() {
        return temDependentes;
    }

    public void setTemDependentes(Boolean temDependentes) {
        this.temDependentes = temDependentes;
    }

    public String getDependente1() {
        return dependente1;
    }

    public void setDependente1(String dependente1) {
        this.dependente1 = dependente1;
    }

    public String getDependente2() {
        return dependente2;
    }

    public void setDependente2(String dependente2) {
        this.dependente2 = dependente2;
    }

    public String getDependente3() {
        return dependente3;
    }

    public void setDependente3(String dependente3) {
        this.dependente3 = dependente3;
    }

    public String getDependente4() {
        return dependente4;
    }

    public void setDependente4(String dependente4) {
        this.dependente4 = dependente4;
    }

    public String getDependente5() {
        return dependente5;
    }

    public void setDependente5(String dependente5) {
        this.dependente5 = dependente5;
    }

    public byte[] getBiometria() {
        return biometria;
    }

    public void setBiometria(byte[] biometria) {
        this.biometria = biometria;
    }

    public byte[] getImagemFacial() {
        return imagemFacial;
    }

    public void setImagemFacial(byte[] imagemFacial) {
        this.imagemFacial = imagemFacial;
    }
}