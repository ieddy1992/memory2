package com.mycompany.memory.model;

public class User {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone;
    private String cpf;
    private String perguntaSecreta1;
    private String perguntaSecreta2;
    private boolean isAdmin;

    // Getters and Setters
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getPerguntaSecreta1() { return perguntaSecreta1; }
    public void setPerguntaSecreta1(String perguntaSecreta1) { this.perguntaSecreta1 = perguntaSecreta1; }

    public String getPerguntaSecreta2() { return perguntaSecreta2; }
    public void setPerguntaSecreta2(String perguntaSecreta2) { this.perguntaSecreta2 = perguntaSecreta2; }

    public boolean isAdmin() { return isAdmin; }
    public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
}
