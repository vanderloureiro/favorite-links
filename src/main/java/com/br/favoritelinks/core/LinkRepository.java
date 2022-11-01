package com.br.favoritelinks.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> getAllByGroupId(Long id);
}
