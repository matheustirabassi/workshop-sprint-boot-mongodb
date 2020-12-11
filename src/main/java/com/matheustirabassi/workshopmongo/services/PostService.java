package com.matheustirabassi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheustirabassi.workshopmongo.domain.Post;
import com.matheustirabassi.workshopmongo.repository.PostRepository;
import com.matheustirabassi.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not founded"));
	}
	
	public List<Post> findByTitle(String txt){
		return repo.findByTitleContainingIgnoreCase(txt);
	}
}
