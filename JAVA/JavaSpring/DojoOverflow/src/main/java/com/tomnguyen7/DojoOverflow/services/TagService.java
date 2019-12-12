package com.tomnguyen7.DojoOverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.DojoOverflow.models.Tag;
import com.tomnguyen7.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	
	public Tag createTag(Tag tag) {
		return this.tagRepository.save(tag);
	}
	
	public void updateTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public Tag findTagById(Long id) {
		Optional<Tag> optionalT = tagRepository.findById(id);
		if(optionalT.isPresent()) {
			return optionalT.get();
		}else {
			return null;
		}
	}
	
	public Tag findOne(String string) {
		Optional<Tag> optionalT = tagRepository.findByTagString(string);
		if(optionalT.isPresent()) {
			return optionalT.get();
		}else {
			return null;
		}
	}
	
}
