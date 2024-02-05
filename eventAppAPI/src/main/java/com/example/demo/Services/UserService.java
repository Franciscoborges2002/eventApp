package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository utilizadorRepository){
        this.userRepository = utilizadorRepository;
    }

    public User getUserById(UUID id) {
        Optional<User> utilizadorById = userRepository.findById(id);

        if (!utilizadorById.isPresent()) {
            throw new IllegalStateException("Não existe utilizador com esse id");
        }

        return utilizadorById.get();
    }

    public User getUserByType(String tipoUtilizador) {
        Optional<User> utilizadores = userRepository.findUtilizadorByTipoUtilizador(tipoUtilizador);

        return utilizadores.get();

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public void addUser(User utilizador) {//Servico para receber o post do controller
        Optional<User> utilizadorByNome = userRepository.findUtilizadorByNome(utilizador.getName());

        if (utilizadorByNome.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse nome!");
        }

        Optional<User> utilizadorByEmail = userRepository.findUtilizadorByEmail(utilizador.getEmail());

        if (utilizadorByEmail.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse email!");
        }

        Optional<User> utilizadorByNomeMostrar = userRepository.findUtilizadorByNomeMostrar(utilizador.getShowName());

        if (utilizadorByNomeMostrar.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse NomeMostrar????!");
        }

        if(utilizador.getPassword() == null ||  utilizador.getTypeUser() == null) {//Verificar se existe password e tipo de utilizador
            throw new IllegalStateException("Existem valores nulos!");
        }

        /* METER A PASSWORD EM HASH ANTES DE GUARDAR NA BD */
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //String hashedPassword = passwordEncoder.encode(utilizador.getPassword());

        //utilizador.setPassword(hashedPassword);

        userRepository.save(utilizador);
    }

    public void deleteUser(UUID id) {
        boolean bool = userRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum utilizador com esse Id"));

        }

        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(UUID id, User utilizador) {

    }
}
