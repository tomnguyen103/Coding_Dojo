package com.tomnguyen7.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tomnguyen7.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
}
