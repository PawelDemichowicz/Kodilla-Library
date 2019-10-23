package com.crud.library.repository;

import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    List<Title> findAll();

    @Override
    Optional<Title> findById(Long id);

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long id);

    Optional<Title> findByTitleLike(String title);
}
