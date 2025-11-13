package com.login.exemplo.Service;

import com.login.exemplo.DTO.UsuarioRequestDTO;
import com.login.exemplo.DTO.UsuarioResponseDTO;
import com.login.exemplo.Entity.Usuario;
import com.login.exemplo.Repostories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUser(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario(usuarioRequestDTO.getName(), usuarioRequestDTO.getEmail(), usuarioRequestDTO.getPassword());
        usuarioRepository.save(usuario);
        //   UsuarioResponseDTO user = new UsuarioResponseDTO(usuario);
        return usuario;
    }

    @PostMapping("login")
    public ResponseEntity<?> findUser(@RequestBody Usuario user) {
        Usuario findUser = usuarioRepository.findByEmail(user.getEmail());
        if (findUser == null) {
            return ResponseEntity.ok("Usuário não encontrado");
        } else {
            if (findUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Logado com sucesso");
            } else {
                return ResponseEntity.ok("Senha incorreta");
            }
        }
    }

    @GetMapping(value = "usuario/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Optional<Usuario> usuariosId(@PathVariable int id) {
        return usuarioRepository.findById(id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteId(@PathVariable int id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuário deletado com sucesso");
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody UsuarioRequestDTO novoUsuario) {
        Optional<Usuario> UsuarioExistente = usuarioRepository.findById(id);

        if (UsuarioExistente.isPresent()) {
            Usuario usuario = UsuarioExistente.get();
            usuario.setName(novoUsuario.getName());
            usuario.setPassword(novoUsuario.getPassword());
            usuarioRepository.save(usuario);
            return usuario.toString();
        } else {
            return "Esse ID não existe";
        }
    }

    @GetMapping(value = "/listar/usuarios")
    public List<UsuarioResponseDTO> listarUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> listaDeUsuarios = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            listaDeUsuarios.add(new UsuarioResponseDTO(usuario));
        }
        return listaDeUsuarios;
    }

    public String deletar1(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Excluído com sucesso";
        } else {
            return "Esse ID não existe";
        }
    }


}
