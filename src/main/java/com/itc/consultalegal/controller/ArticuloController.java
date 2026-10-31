package com.itc.consultalegal.controller;

import com.itc.consultalegal.entity.Articulo;
import com.itc.consultalegal.service.ArticuloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.findAll();
        model.addAttribute("articulos", articulos);
        model.addAttribute("titulo", "Todos los Artículos sobre Ciberdelitos");
        return "lista-articulos";
    }

    @GetMapping("/{id}")
    public String verDetalleArticulo(@PathVariable Long id, Model model) {
        return articuloService.findById(id)
                .map(articulo -> {
                    model.addAttribute("articulo", articulo);
                    return "detalle-articulo";
                })
                .orElse("redirect:/articulos");
    }

    @GetMapping("/ver/{numero}")
    public String verPorNumero(@PathVariable String numero, Model model) {
        return articuloService.findByNumeroExacto(numero)
                .map(articulo -> "redirect:/articulos/" + articulo.getId())
                .orElse("redirect:/articulos");
    }

    @GetMapping("/buscar")
    public String buscarArticulos(@RequestParam(value = "q", required = false) String query, Model model) {
        List<Articulo> articulos;
        if (query != null && !query.trim().isEmpty()) {
            articulos = articuloService.search(query);
            model.addAttribute("titulo", "Resultados de búsqueda: " + query);
            model.addAttribute("query", query);
        } else {
            articulos = articuloService.findAll();
            model.addAttribute("titulo", "Todos los Artículos sobre Ciberdelitos");
        }
        model.addAttribute("articulos", articulos);
        return "lista-articulos";
    }

    @GetMapping("/numero/{numero}")
    public String buscarPorNumero(@PathVariable String numero, Model model) {
        List<Articulo> articulos = articuloService.findByNumeroArticulo(numero);
        if (articulos.isEmpty()) {
            model.addAttribute("titulo", "No se encontraron artículos con número: " + numero);
        } else {
            model.addAttribute("titulo", "Artículo " + numero + " - " + articulos.get(0).getTitulo());
        }
        model.addAttribute("articulos", articulos);
        return "lista-articulos";
    }

}