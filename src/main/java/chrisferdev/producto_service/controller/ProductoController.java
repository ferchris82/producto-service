package chrisferdev.producto_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import chrisferdev.producto_service.dto.ProductoRequest;
import chrisferdev.producto_service.dto.ProductoResponse;
import chrisferdev.producto_service.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarProducto(@RequestBody ProductoRequest productoRequest){
        productoService.createProducto(productoRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoResponse> listarProductos(){
        return productoService.getAllProductos();
    }
}
