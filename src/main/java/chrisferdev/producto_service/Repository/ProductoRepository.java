package chrisferdev.producto_service.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import chrisferdev.producto_service.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    
}
