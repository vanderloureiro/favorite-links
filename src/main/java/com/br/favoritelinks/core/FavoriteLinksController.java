package com.br.favoritelinks.core;

import com.br.favoritelinks.core.record.GroupDto;
import com.br.favoritelinks.core.record.GroupForm;
import com.br.favoritelinks.core.record.LinkDto;
import com.br.favoritelinks.core.record.LinkForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteLinksController {

    private final GroupRepository groupRepository;
    private final LinkRepository linkRepository;

    public FavoriteLinksController(GroupRepository groupRepository, LinkRepository linkRepository) {
        this.groupRepository = groupRepository;
        this.linkRepository = linkRepository;
    }

    @PostMapping("/group")
    public ResponseEntity<Void> createGroup(@RequestBody GroupForm form) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/group")
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/link")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkForm form) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/links-by-group/{id}")
    public ResponseEntity<List<LinkDto>> getAllLinksByGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok().build();
    }

}
