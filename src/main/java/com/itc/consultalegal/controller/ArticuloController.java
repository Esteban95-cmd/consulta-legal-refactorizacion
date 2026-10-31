package com.itc.consultalegal.controller;

import com.itc.consultalegal.entity.Articulo;
import com.itc.consultalegal.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.findAll();
        model.addAttribute("articulos", articulos);
        model.addAttribute("titulo", "Todos los Artículos sobre Ciberdelitos");
        return "lista-articulos";
    }

    @GetMapping("/{id}")
    public String verDetalleArticulo(@PathVariable Long id, Model model) {
        Optional<Articulo> articuloOpt = articuloService.findById(id);
        if (articuloOpt.isPresent()) {
            model.addAttribute("articulo", articuloOpt.get());
            return "detalle-articulo";
        } else {
            return "redirect:/articulos";
        }
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

    @GetMapping("/ver/{numero}")
    public String verPorNumero(@PathVariable String numero, Model model) {
        Optional<Articulo> articuloOpt = articuloService.findByNumeroExacto(numero);
        if (articuloOpt.isPresent()) {
            return "redirect:/articulos/" + articuloOpt.get().getId();
        } else {
            return "redirect:/articulos";
        }
    }
}