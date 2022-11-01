package com.br.favoritelinks.core;

import com.br.favoritelinks.core.record.GroupDto;
import com.br.favoritelinks.core.record.GroupForm;
import com.br.favoritelinks.core.record.LinkDto;
import com.br.favoritelinks.core.record.LinkForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        Group group = Group.builder().name(form.name()).build();
        this.groupRepository.save(group);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/group")
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        List<GroupDto> groups = this.groupRepository
                .findAll()
                .stream()
                .map(group -> {
                    return new GroupDto(group.getId(), group.getName());
                }).collect(Collectors.toList());
        return ResponseEntity.ok(groups);
    }

    @PostMapping("/link")
    public ResponseEntity<Void> createLink(@RequestBody LinkForm form) {
        Group group = this.groupRepository.findById(form.groupId()).orElseThrow();

        Link link = Link.builder()
                .description(form.description())
                .link(form.link())
                .group(group)
                .build();

        linkRepository.save(link);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/links-by-group/{id}")
    public ResponseEntity<List<LinkDto>> getAllLinksByGroup(@PathVariable Long groupId) {
        List<LinkDto> links = this.linkRepository
                .getAllByGroupId(groupId)
                .stream()
                .map(link -> {
                    return new LinkDto(link.getId(), link.getDescription(), link.getLink(), link.getGroup().getId());
                }).collect(Collectors.toList());
        return ResponseEntity.ok(links);
    }

}
