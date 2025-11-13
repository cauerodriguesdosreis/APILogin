package com.login.exemplo.DTO;
import com.login.exemplo.Entity.Usuario;

public class UsuarioResponseDTO {
    private int id;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UsuarioResponseDTO(Usuario user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
