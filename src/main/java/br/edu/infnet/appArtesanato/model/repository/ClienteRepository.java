package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("from Cliente a where a.usuario.id = :id")
    public List<Cliente> obterLista(Long id);

}
