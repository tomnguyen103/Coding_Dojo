package com.tomnguyen7.DojoOverflow.services;

import org.springframework.stereotype.Service;


import com.tomnguyen7.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
//	public ArrayList<Tag> findAllTags(){
//		return (ArrayList<Tag>) this.tagRepository.findAll();
//	}
//	
//	public Tag createTag(Tag tag) {
//		return this.tagRepository.save(new Tag(tag));
//	}
	
}
