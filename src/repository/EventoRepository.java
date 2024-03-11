package repository;

import models.Evento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventoRepository {
    private final List<Evento> eventos = new ArrayList<>();

    public Evento addEvento(Evento evento) {
        eventos.add(evento);
        return evento;
    }

    public boolean removeEvento(Long id) {
        return eventos.removeIf(events -> events.getId().equals(id));
    }

    public List<Evento> listarEventos() {
        return new ArrayList<>(eventos);
    }

    public Optional<Evento> encontrarEventoPorId(Long id) {
        return eventos.stream()
                .filter(evento -> evento.getId().equals(id))
                .findFirst();
    }
}
