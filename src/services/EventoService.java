package services;

import models.Evento;
import repository.EventoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criarEvento(String name, String description, String address, LocalDateTime time, String category) {
        Evento novoEvento = new Evento();

        novoEvento.setName(name);
        novoEvento.setDescription(description);
        novoEvento.setAddress(address);
        novoEvento.setTime(time);
        novoEvento.setCategory(category);

        return novoEvento;
    }

    public List<Evento> listarEventos() {
        return eventoRepository.listarEventos();
    }

    public Optional<Evento> buscarEventoPorId(Long id) {
        return eventoRepository.encontrarEventoPorId(id);
    }

    public boolean removerEvento(Long id) {
        // TODO: verificar evento
        return eventoRepository.removeEvento(id);
    }
}
