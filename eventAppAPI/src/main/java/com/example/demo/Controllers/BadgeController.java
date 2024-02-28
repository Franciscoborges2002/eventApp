package com.example.demo.Controllers;

import com.example.demo.Models.Badge;
import com.example.demo.Services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("badge")
public class BadgeController {

    private final BadgeService badgeService;

    @Autowired
    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping
    public List<Badge> getBadges() {
        return badgeService.getBadges();
    }

    @GetMapping(path = "{badgeId}")
    public Badge getBadgeById(@PathVariable("companyId") UUID id) {
        return badgeService.getBadgeById(id);
    }

    @GetMapping(path = "{badgeName}")
    public Badge getBadgeByName(@PathVariable String badgeName) {

        //Verificar se a string vinda existe no TipoUtilizador
        return badgeService.getBadgeByName(badgeName);
    }

    @PostMapping
    public void addBadge(@RequestBody Badge badge) {
        System.out.println("A receber badge para criar");
        badgeService.addBadge(badge);
    }

    @DeleteMapping(path = "{badgeId}")
    public void deleteBadge(@PathVariable("badgeId") UUID id) {
        System.out.println("A receber badge par eliminar");
        badgeService.deleteBadge(id);
    }

    @PutMapping(path = "{badgeId}")//Receber utilizador inteiro do frontend
    public void updateBadge(@PathVariable("badgeId") UUID id, @RequestBody Badge badge) {
        System.out.println("A receber badge par mudar");
        badgeService.updateBadge(id, badge);
    }
}
