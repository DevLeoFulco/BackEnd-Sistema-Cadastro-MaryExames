package br.com.maryexames.service;

import br.com.maryexames.model.Paciente;
import br.com.maryexames.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        Paciente pacienteExistente = pacienteRepository.findById(id).orElse(null);
        if (pacienteExistente != null) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}