package chrisferdev.producto_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chrisferdev.producto_service.Repository.ProductoRepository;
import chrisferdev.producto_service.dto.ProductoRequest;
import chrisferdev.producto_service.dto.ProductoResponse;
import chrisferdev.producto_service.model.Producto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public void createProducto(ProductoRequest ProductoRequest){
        Producto producto = Producto.builder()
                 .nombre(ProductoRequest.getNombre())
                 .descripcion(ProductoRequest.getDescripcion())
                 .precio(ProductoRequest.getPrecio())
                 .build();
        productoRepository.save(producto);
        log.info("Producto{} ha sido guardado con exito", producto.getId());
    }

    public List<ProductoResponse> getAllProductos(){
        List<Producto> productos = productoRepository.findAll();
        return  productos.stream().map(this::mapToProductoResponse).collect(Collectors.toList());
    }

    private ProductoResponse mapToProductoResponse(Producto producto){
        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .build();
    }
}
