package springboot.grupoextra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import springboot.grupoextra.model.EmpresaModel;
import springboot.grupoextra.repository.EmpresaRepository;


@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaModel criarEmpresa(EmpresaModel empresa) {
        if (empresa.getNome() == null || empresa.getEmail() == null || empresa.getSenha() == null) {
            throw new IllegalArgumentException("Nome, email e senha são obrigatórios");
        }

        if (empresa.getEmail().isEmpty() || !empresa.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (empresa.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres");
        }

        // Hash da senha usando BCrypt
        String senhaHash = BCrypt.hashpw(empresa.getSenha(), BCrypt.gensalt());
        empresa.setSenha(senhaHash);

        // Hash do email para armazenamento mais seguro
        String emailHash = BCrypt.hashpw(empresa.getEmail(), BCrypt.gensalt());
        empresa.setEmail(emailHash);

        return empresaRepository.save(empresa);    
    }

    public List<EmpresaModel> getAll() {
        return empresaRepository.findAll();
    }

    public boolean Login(String email, String senha) {
        EmpresaModel empresa = empresaRepository.findByEmail(email);
        if (empresa == null) {
            throw new  IllegalAccessError ("Usuário não encontrado");
        }
        return BCrypt.checkpw(senha, empresa.getSenha());
        
    }

    public EmpresaModel delete (Long id) {
        EmpresaModel empresa = empresaRepository.findById(id).orElse(null);
        if (empresa == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        empresaRepository.deleteById(id);
        return null;
    }
    
}
