package com.example.demo.Services;

import com.example.demo.Models.Badge;
import com.example.demo.Models.Company;
import com.example.demo.Repositories.BadgeRepository;
import com.example.demo.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }


    public List<Badge> getBadges() {
        return badgeRepository.findAll();
    }

    public Badge getBadgeById(UUID id) {
        Optional<Badge> badgeById = badgeRepository.findById(id);

        if (!badgeById.isPresent()) {
            throw new IllegalStateException("Não existe badge com esse id");
        }

        return badgeById.get();
    }

    public Badge getBadgeByName(String badgeName) {
        Optional<Badge> badgeByName = badgeRepository.findBadgeByName(badgeName);

        if (!badgeByName.isPresent()) {
            throw new IllegalStateException("Não existe badge com esse nome");
        }

        return badgeByName.get();
    }

    public void addBadge(Badge badge) {
        Optional<Badge> badgeByName = badgeRepository.findBadgeByName(badge.getName());

        if (badgeByName.isPresent()) {
            throw new IllegalStateException("Already exists a Badge with that name!");
        }

        //So foi feita a verificacao do nomme

        badgeRepository.save(badge);
    }

    public void deleteBadge(UUID id) {
        boolean bool = badgeRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Not exists any badge with that id!"));
        }

        badgeRepository.deleteById(id);
    }

    public void updateBadge(UUID id, Badge badge) {
    }
}
