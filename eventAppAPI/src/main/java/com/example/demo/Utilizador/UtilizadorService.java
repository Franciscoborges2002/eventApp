package com.example.demo.Utilizador;

import com.example.demo.Enums.TipoUtilizador;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UtilizadorService {

    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository){
        this.utilizadorRepository = utilizadorRepository;
    }

    public Utilizador getUtilizadorById(Long id) {
        Optional<Utilizador> utilizadorById = utilizadorRepository.findById(id);

        if (!utilizadorById.isPresent()) {
            throw new IllegalStateException("Não existe utilizador com esse id");
        }

        return utilizadorById.get();
    }

    public Utilizador getUtilizadorByType(String tipoUtilizador) {
        Optional<Utilizador> utilizadores = utilizadorRepository.findUtilizadorByTipoUtilizador(tipoUtilizador);

        return utilizadores.get();

    }

    public List<Utilizador> getUtilizadores() {
        return utilizadorRepository.findAll();
    }


    public void addNewUtilizador(Utilizador utilizador) {//Servico para receber o post do controller
        Optional<Utilizador> utilizadorByNome = utilizadorRepository.findUtilizadorByNome(utilizador.getNome());

        if (utilizadorByNome.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse nome!");
        }

        Optional<Utilizador> utilizadorByEmail = utilizadorRepository.findUtilizadorByEmail(utilizador.getEmail());

        if (utilizadorByEmail.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse email!");
        }

        Optional<Utilizador> utilizadorByNomeMostrar = utilizadorRepository.findUtilizadorByNomeMostrar(utilizador.getNomeMostrar());

        if (utilizadorByNomeMostrar.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse NomeMostrar????!");
        }

        if(utilizador.getPassword() == null ||  utilizador.getTipoUtilizador() == null) {//Verificar se existe password e tipo de utilizador
            throw new IllegalStateException("Existem valores nulos!");
        }

        /* METER A PASSWORD EM HASH ANTES DE GUARDAR NA BD */
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //String hashedPassword = passwordEncoder.encode(utilizador.getPassword());

        //utilizador.setPassword(hashedPassword);

        utilizadorRepository.save(utilizador);
    }

    public void deleteUtilizador(Long id) {
        boolean bool = utilizadorRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum utilizador com esse Id"));

        }

        utilizadorRepository.deleteById(id);
    }

    @Transactional
    public void updateUtilizador(Long id, Utilizador utilizador) {

    }
}
