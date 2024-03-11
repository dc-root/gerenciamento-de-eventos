package repository;

import models.Evento;
import models.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParticipanteRepository {
    private final List<Participante> participantes = new ArrayList<>();

    public Participante addParticipante(Participante participante) {
        participantes.add(participante);
        return participante;
    }

    public boolean removeParticipante(Long id) {
        return participantes.removeIf(events -> events.getId().equals(id));
    }

    public List<Participante> listarParticipantes() {
        return new ArrayList<>(participantes);
    }

    public Optional<Participante> encontrarParticipantePorId(Long id) {
        return participantes.stream()
                .filter(evento -> evento.getId().equals(id))
                .findFirst();
    }
}
