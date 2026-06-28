package com.banco.banco_arboleda.repository;

import com.banco.banco_arboleda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuarioAndClave(String usuario, String clave);
}