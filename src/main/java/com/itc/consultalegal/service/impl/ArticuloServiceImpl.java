package com.itc.consultalegal.service.impl;

import com.itc.consultalegal.entity.Articulo;
import com.itc.consultalegal.repository.ArticuloRepository;
import com.itc.consultalegal.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> findById(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public void deleteById(Long id) {
        articuloRepository.deleteById(id);
    }

    @Override
    public List<Articulo> search(String termino) {
        if (termino == null || termino.trim().isEmpty()) {
            return findAll();
        }
        return articuloRepository.search(termino.trim());
    }

    @Override
    public List<Articulo> findByNumeroArticulo(String numeroArticulo) {
        return articuloRepository.findByNumeroArticuloContaining(numeroArticulo);
    }

    @Override
    public Optional<Articulo> findByNumeroExacto(String numeroArticulo) {
        List<Articulo> articulos = articuloRepository.findByNumeroArticuloContaining(numeroArticulo);
        return articulos.stream()
                .filter(a -> a.getNumeroArticulo().equalsIgnoreCase(numeroArticulo))
                .findFirst();
    }
}