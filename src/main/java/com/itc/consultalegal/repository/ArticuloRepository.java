package com.itc.consultalegal.repository;

import com.itc.consultalegal.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    
    List<Articulo> findByTituloContainingIgnoreCase(String titulo);
    
    List<Articulo> findByContenidoContainingIgnoreCase(String contenido);
    
    List<Articulo> findByNumeroArticuloContaining(String numeroArticulo);
    
    @Query("SELECT a FROM Articulo a WHERE " +
           "LOWER(a.titulo) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
           "LOWER(a.contenido) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
           "LOWER(a.numeroArticulo) LIKE LOWER(CONCAT('%', :termino, '%'))")
    List<Articulo> search(@Param("termino") String termino);
}