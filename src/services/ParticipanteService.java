package services;

import models.Participante;
import repository.ParticipanteRepository;

import java.util.List;
import java.util.Optional;

public class ParticipanteService {
    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public Participante criarParticipante(String name, String email) {
        Participante novoParticipante = new Participante();

        novoParticipante.setName(name);
        novoParticipante.setEmail(email);

        return novoParticipante;
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.listarParticipantes();
    }

    public Optional<Participante> buscarParticipantePorId(Long id) {
        return participanteRepository.encontrarParticipantePorId(id);
    }

    public boolean removerParticipante(Long id) {

        // TODO: verificar participante
        return participanteRepository.removeParticipante(id);
    }
}
