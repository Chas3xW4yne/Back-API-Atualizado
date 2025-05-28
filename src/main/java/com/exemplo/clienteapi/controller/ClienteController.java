package com.exemplo.clienteapi.controller;

import com.exemplo.clienteapi.model.Cliente;
import com.exemplo.clienteapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public void criarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public String atualizarCliente(@PathVariable int id, @RequestBody Cliente dados) {
        return clienteRepository.update(id, dados) ? "Atualizado com sucesso" : "Cliente não encontrado";
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable int id) {
        if (clienteRepository.findAll().isEmpty()) {
            Cliente.resetarId();
        }
        return clienteRepository.delete(id) ? "Deletado com sucesso" : "Cliente não encontrado";
    }
}
