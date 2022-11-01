package com.br.favoritelinks.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LinkRepository extends JpaRepository<Link, Long> {
}
