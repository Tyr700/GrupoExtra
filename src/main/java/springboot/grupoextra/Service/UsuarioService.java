package springboot.grupoextra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.grupoextra.model.UsuarioModel;
import springboot.grupoextra.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel criarUsuario(UsuarioModel usuario) {
    
    }

    public UsuarioModel salvar(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll();
    }
    
}
