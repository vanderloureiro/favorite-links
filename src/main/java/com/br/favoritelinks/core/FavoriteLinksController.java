package com.br.favoritelinks.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteLinksController {

    private final GroupRepository groupRepository;
    private final LinkRepository linkRepository;

    public FavoriteLinksController(GroupRepository groupRepository, LinkRepository linkRepository) {
        this.groupRepository = groupRepository;
        this.linkRepository = linkRepository;
    }

    @PostMapping("/group")
    public ResponseEntity<Void> createGroup() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/group")
    public ResponseEntity<Void> getAllGroups() {
        return ResponseEntity.ok().build();
    }
}
