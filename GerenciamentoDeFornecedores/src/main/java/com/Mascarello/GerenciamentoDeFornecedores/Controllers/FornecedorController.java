package com.Mascarello.GerenciamentoDeFornecedores.Controllers;

import com.Mascarello.GerenciamentoDeFornecedores.Models.FornecedorModel;
import com.Mascarello.GerenciamentoDeFornecedores.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criarfornecedor(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel requeste = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(fornecedorModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);

    }

    @DeleteMapping
    public ResponseEntity<?> excluirFornecedor(@PathVariable Long id){
        fornecedorService.excluirFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listarFornecedores(){
        List<FornecedorModel> requeste = fornecedorService.listarFornecedores();
        return ResponseEntity.ok().body(requeste);
    }

    @PutMapping
    public ResponseEntity<FornecedorModel> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel){
        FornecedorModel requeste = fornecedorService.atualizarFornecedor(id, fornecedorModel);
        return ResponseEntity.ok().body(requeste);

    }

}
