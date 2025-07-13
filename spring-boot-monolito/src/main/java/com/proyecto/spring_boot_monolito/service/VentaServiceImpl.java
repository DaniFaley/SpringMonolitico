package com.proyecto.spring_boot_monolito.service;

import com.proyecto.spring_boot_monolito.model.Venta;
import com.proyecto.spring_boot_monolito.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService{
    // Constructor
    private final VentaRepository ventaRepository;
    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    // Crear registro
    @Override
    public Venta createVenta(Venta venta) {
        venta.setFechaVenta(LocalDateTime.now());
        return ventaRepository.save(venta);
    }

    // Eliminar registro
    @Override
    public void deleteVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    // Modificar registro
    @Override
    public Venta updateVenta(Long idVenta, Venta venta) {
        // Buscar registro por su Id
        Venta ventaExistente = ventaRepository.findById(idVenta).orElse(null);
        // Si no existe el registro retornara null
        if (ventaExistente == null) {
            return null;
        }
        // Actualizar campos del registro => Setters
        ventaExistente.setFkIdProducto(venta.getFkIdProducto());
        ventaExistente.setFkIdUsuario(venta.getFkIdUsuario());
        ventaExistente.setNombre(venta.getNombre());
        ventaExistente.setFechaVenta(venta.getFechaVenta());
        ventaExistente.setCantidad(venta.getCantidad());
        ventaExistente.setPrecioUnitario(venta.getPrecioUnitario());
        // Retornar y guardar
        return ventaRepository.save(ventaExistente);
    }

    // Obtener los registros de un usuario mediante su fkIdUsuario
    @Override
    public List<Venta> findByFkIdUsuario(Long fkIdUsuario) {
        return ventaRepository.findByFkIdUsuario(fkIdUsuario);
    }

    // Obtener un registro en especifico mediante su id
    @Override
    public Optional<Venta> findById(Long idVenta) {
        return ventaRepository.findById(idVenta);
    }

    // Obtener todos los registros
    @Override
    public List<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }
}
