package Cohorte14Equipo21.back.service;

import Cohorte14Equipo21.back.modelos.registrodecompra.RegistroDeCompra;
import Cohorte14Equipo21.back.modelos.usuarios.usuario.User;
import Cohorte14Equipo21.back.repositorios.RegistroDeCompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroDeCompraService {

    @Autowired
    private RegistroDeCompraRepository registroDeCompraRepository;
    @Autowired
    private EntityManager entityManager;


    public Optional<RegistroDeCompra> buscarRegistro(Long id){
        User usuario = entityManager.find(User.class, id);
        if (usuario == null) return  null;

        String jpql = "SELECT r FROM RegistroDeCompra r WHERE r.usuario = :usuario";
        TypedQuery<RegistroDeCompra> query = entityManager.createQuery(jpql, RegistroDeCompra.class);
        query.setParameter("usuario", usuario);
        try{
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return null;
        }
    }

    public void guardar(RegistroDeCompra registroDeCompra){
        registroDeCompraRepository.save(registroDeCompra);
    }

    public RegistroDeCompra buscarPorIdDelCliente(Long id){
        Optional<RegistroDeCompra> registro = Optional.of(registroDeCompraRepository.buscarPorClienteId(id));
        return registro.orElse(null);
    }

}
