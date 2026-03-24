package com.Mascarello.GerenciamentoDeFornecedores.Services;

import com.Mascarello.GerenciamentoDeFornecedores.Models.FornecedorModel;
import com.Mascarello.GerenciamentoDeFornecedores.Repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    public void excluirFornecedor(@PathVariable Long id){
        fornecedorRepository.deleteById(id);
    }

    public FornecedorModel criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);


    }

    public List<FornecedorModel> listarFornecedores(){
        return fornecedorRepository.findAll();

    }

    public FornecedorModel atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel){
        FornecedorModel fornecedorNovo = fornecedorRepository.findById(id).get();
        fornecedorNovo.setNomeFantasia(fornecedorModel.getNomeFantasia());
        return fornecedorRepository.save(fornecedorNovo);
    }


}
