package com.login.exemplo.Controller;

import com.login.exemplo.DTO.UsuarioRequestDTO;
import com.login.exemplo.DTO.UsuarioResponseDTO;
import com.login.exemplo.Entity.Usuario;
import com.login.exemplo.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "cadastro")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(usuarioRequestDTO));

    }
}
//
//    @PostMapping("login")
//    public ResponseEntity<?> findUser(@RequestBody Usuario user) {
//        Usuario findUser = usuarioRepository.findByEmail(user.getEmail());
//        if (findUser == null) {
//            return ResponseEntity.ok("Usuário não encontrado");
//        } else {
//            if (findUser.getPassword().equals(user.getPassword())) {
//                return ResponseEntity.ok("Logado com sucesso");
//            } else {
//                return ResponseEntity.ok("Senha incorreta");
//            }
//        }
//    }
//}

//    @GetMapping(value = "usuario/listar")
//    public List<Usuario> listarUsuarios() {
//        return usuarioRepository.findAll();
//    }
//
//    @GetMapping(value = "{id}")
//    public Optional<Usuario> usuariosId(@PathVariable int id) {
//        return usuarioRepository.findById(id);
//    }
//
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<?> deleteId(@PathVariable int id) {
//    return ResponseEntity.ok(usuarioService.deletar1(id));
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Usuario novoUsuario) {
//        Optional<Usuario> UsuarioExistente = usuarioRepository.findById(id);
//
//        if (UsuarioExistente.isPresent()) {
//            Usuario usuario = UsuarioExistente.get();
//            usuario.setName(novoUsuario.getName());
//            usuario.setPassword(novoUsuario.getPassword());
//            usuarioRepository.save(usuario);
//            return ResponseEntity.ok("Atualizado com sucesso");
//        } else {
//            return ResponseEntity.ok("Esse id já existe");
//        }
//    }
//    @GetMapping(value = "/listar/usuarios")
//    public List<UsuarioResponseDTO> listarUsuario() {
//        List<Usuario> usuarios = usuarioRepository.findAll();
//        List<UsuarioResponseDTO> listaDeUsuarios = new ArrayList<>();
//
//        for (Usuario usuario : usuarios) {
//            listaDeUsuarios.add(new UsuarioResponseDTO(usuario));
//        }
//        return listaDeUsuarios;
//    }
//    }
