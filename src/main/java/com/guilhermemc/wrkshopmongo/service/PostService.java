 package com.guilhermemc.wrkshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermemc.wrkshopmongo.domain.Post;
import com.guilhermemc.wrkshopmongo.repository.PostRepository;
import com.guilhermemc.wrkshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	// metedo desativado por motivo de que tambem e possivel buscar por querys direto...
	//public List<Post> findByTitle(String text){
	//	return repo.findByTitleContainingIgnoreCase(text);
	//}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate= new Date(maxDate.getTime()+ 24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);	
	}
	
}
