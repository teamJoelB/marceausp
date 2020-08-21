package fr.marceau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.marceau.entities.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
