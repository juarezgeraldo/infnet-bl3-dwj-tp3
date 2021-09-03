package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obterLista() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario validar(String email, String senha) {
        return usuarioRepository.autenticacao(email, senha);
    }


}
