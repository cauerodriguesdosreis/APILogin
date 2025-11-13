//package com.login.exemplo.Controller;
//
//import com.login.exemplo.DTO.ProdutoResponseDTO;
//import com.login.exemplo.Entity.Produto;
//import com.login.exemplo.Repostories.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("produto")
//
//public class ProdutoController {
//
//    @Autowired
//    ProdutoRepository produtoRepository;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
//
//        Optional<Produto> produto = produtoRepository.findById(id);
//
//        if (produto.isPresent()) {
//            return ResponseEntity.ok(produto);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
//        }
//    }
//
//    @GetMapping("/listar")
//    public ResponseEntity<?> listarProdutos() {
//        List<Produto> lista = produtoRepository.findAll();
//        if (lista.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista vazia");
//        } else {
//            return ResponseEntity.ok((Produto) lista);
//        }
//
//    }
//
//    @PostMapping("/criar")
//    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
//        Produto novoProduto = new Produto(
//                produto.getName(), produto.getPrice(), produto.getQuantity());
//        produtoRepository.save(novoProduto);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
//    }
//
//    @DeleteMapping
//    public ResponseEntity<?> deletarId(@PathVariable int id) {
//        boolean deletarProduto = produtoRepository.existsById(id);
//
//        if (deletarProduto) {
//            produtoRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Produto deletado com sucesso");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
//        }
//    }
//
//    @PutMapping("/atualizar/{id}")
//    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Produto novoProduto) {
//        Optional<Produto> produtoExistente = produtoRepository.findById(id);
//
//        if (produtoExistente.isPresent()) {
//            Produto produto = produtoExistente.get();
//            produto.setName(novoProduto.getName());
//            produto.setPrice(novoProduto.getPrice());
//            produto.setQuantity(novoProduto.getQuantity());
//            produtoRepository.save(produto);
//            return ResponseEntity.ok("Atualizado com sucesso");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse ID não existe");
//        }
//    }
//
//    @GetMapping(value = "listar")
//    public List<ProdutoResponseDTO> listarUsuario() {
//
//        List<Produto> produtos = produtoRepository.findAll();
//        List<ProdutoResponseDTO> listaDeProdutos = produtos.stream().map(ProdutoResponseDTO::new).toList();
//        for (Produto produto : produtos) {
//            listaDeProdutos.add(new ProdutoResponseDTO(produto));
//        }
//
//        return listaDeProdutos;
//
//    }
//}
