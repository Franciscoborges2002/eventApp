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
        Optional<User> userById = userRepository.findById(id);

        if (!userById.isPresent()) {
            throw new IllegalStateException("Não existe utilizador com esse id");
        }

        return userById.get();
    }

    //Nao sei se isto funciona verificar
    public List<User> getUserByType(String typeUser) {
        //Optional<User> users = userRepository.findUsersByTypeUser(typeUser);

        //return users.stream().toList();
        return null;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public void addUser(User user) {//Servico para receber o post do controller
        Optional<User> userByNome = userRepository.findUserByName(user.getName());

        if (userByNome.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse nome!");
        }

        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse email!");
        }

        Optional<User> userByShowName = userRepository.findUserByShowName(user.getShowName());

        if (userByShowName.isPresent()) {
            throw new IllegalStateException("Ja existe um utilizador com esse NomeMostrar????!");
        }

        if(user.getPassword() == null ||  user.getTypeUser() == null) {//Verificar se existe password e tipo de utilizador
            throw new IllegalStateException("Existem valores nulos!");
        }

        /* METER A PASSWORD EM HASH ANTES DE GUARDAR NA BD */
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //String hashedPassword = passwordEncoder.encode(utilizador.getPassword());

        //utilizador.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        boolean bool = userRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum utilizador com esse Id"));

        }

        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(UUID id, User user) {

    }
}
