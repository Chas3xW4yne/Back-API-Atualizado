package com.exemplo.clienteapi.repository;

import com.exemplo.clienteapi.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll() {
        return clientes;
    }

    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    public Optional<Cliente> findById(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public boolean update(int id, Cliente dados) {
        Optional<Cliente> clienteOpt = findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNome(dados.getNome());
            cliente.setEmail(dados.getEmail());
            cliente.setTelefone(dados.getTelefone());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }
}
