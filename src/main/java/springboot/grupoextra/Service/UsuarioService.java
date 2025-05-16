package springboot.grupoextra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import springboot.grupoextra.model.UsuarioModel;
import springboot.grupoextra.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel criarUsuario(UsuarioModel usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new IllegalArgumentException("Nome, email e senha são obrigatórios");
        }

        if (usuario.getEmail().isEmpty() || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (usuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres");
        }

        // Hash da senha usando BCrypt
        String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
        usuario.setSenha(senhaHash);

        // Hash do email para armazenamento mais seguro
        String emailHash = BCrypt.hashpw(usuario.getEmail(), BCrypt.gensalt());
        usuario.setEmail(emailHash);

        return usuarioRepository.save(usuario);    
    }

    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll();
    }

    public boolean Login(String email, String senha) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new  IllegalAccessError ("Usuário não encontrado");
        }
        return BCrypt.checkpw(senha, usuario.getSenha());
        
    }

    public void delete (Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
    
}
