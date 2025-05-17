package springboot.grupoextra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.grupoextra.Service.EmpresaService;
import springboot.grupoextra.model.EmpresaModel;

@RestController
@RequestMapping("/usuario")
public class EmpresaController {
    
    @Autowired
    private EmpresaService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<EmpresaModel> cadastro(@RequestBody EmpresaModel usuario) {
        usuario =  usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@PathVariable String email, @PathVariable String senha ) {
        boolean login = usuarioService.Login(email, senha);
        if (login == true) {
            return ResponseEntity.status(HttpStatus.OK).body(login);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(login);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<EmpresaModel> delete(@PathVariable Long id) {
         EmpresaModel usuario = usuarioService.delete(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuario);
    }

    @GetMapping("/listausuarios")
    public ResponseEntity<List<EmpresaModel>> listarUsuarios () {
        List<EmpresaModel> usuarios = usuarioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }
}
