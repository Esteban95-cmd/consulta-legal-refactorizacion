package com.itc.consultalegal.service;

import com.itc.consultalegal.entity.Articulo;
import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    List<Articulo> findAll();
    Optional<Articulo> findById(Long id);
    Articulo save(Articulo articulo);
    void deleteById(Long id);
    List<Articulo> search(String termino);
    List<Articulo> findByNumeroArticulo(String numeroArticulo);
    Optional<Articulo> findByNumeroExacto(String numeroArticulo);
}