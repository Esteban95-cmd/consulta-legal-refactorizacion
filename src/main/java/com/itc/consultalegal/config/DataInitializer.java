package com.itc.consultalegal.config;

import com.itc.consultalegal.entity.Articulo;
import com.itc.consultalegal.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

        @Autowired
        private ArticuloRepository articuloRepository;

        @Override
        public void run(String... args) throws Exception {
                if (articuloRepository.count() == 0) {
                        System.out.println("Inicializando datos...");
                        inicializarDatos();
                } else {
                        System.out.println(
                                        "La base de datos ya contiene artículos. Se conservan los datos existentes.");
                }

                long count = articuloRepository.count();
                System.out.println("Total de artículos en la base de datos: " + count);

                List<Articulo> todos = articuloRepository.findAll();
                System.out.println("Artículos en la base de datos:");
                for (Articulo art : todos) {
                        System.out.println(" - " + art.getNumeroArticulo() + ": " + art.getTitulo() + " (ID: "
                                        + art.getId() + ")");
                }
        }

        private void inicializarDatos() {
                List<Articulo> articulos = ArticuloDataProvider.obtenerArticulosIniciales();

                articuloRepository.saveAll(articulos);
                System.out.println("Se intentaron guardar " + articulos.size() + " artículos");
        }
}