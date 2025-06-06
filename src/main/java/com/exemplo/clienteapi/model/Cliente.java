package com.exemplo.clienteapi.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private static int incrementId = 1;

    public Cliente() {
        this.id = incrementId++;
    }

    public Cliente(String nome, String email, String telefone) {
        this.id = incrementId++;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public static void resetarId() {
        incrementId = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static int getIncrementId() {
        return incrementId;
    }

    public static void setIncrementId(int incrementId) {
        Cliente.incrementId = incrementId;
    }
}
