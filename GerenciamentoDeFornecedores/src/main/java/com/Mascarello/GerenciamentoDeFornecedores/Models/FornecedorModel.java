package com.Mascarello.GerenciamentoDeFornecedores.Models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Table(name = "tb_fornecedor")
public class FornecedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_Fantasia_do_fornecedor")
    private String nomeFantasia;
    private String cnpj;
    @Column(name = "contato_Do_Fornecedor")
    private String contatoDoFornecedor;

    public FornecedorModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContatoDoFornecedor() {
        return contatoDoFornecedor;
    }

    public void setContatoDoFornecedor(String contatoDoFornecedor) {
        this.contatoDoFornecedor = contatoDoFornecedor;
    }
}


