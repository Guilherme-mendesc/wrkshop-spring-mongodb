package com.guilhermemc.wrkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilhermemc.wrkshopmongo.domain.Post;
import com.guilhermemc.wrkshopmongo.domain.User;
import com.guilhermemc.wrkshopmongo.dto.AuthorDTO;
import com.guilhermemc.wrkshopmongo.dto.CommentDTO;
import com.guilhermemc.wrkshopmongo.repository.PostRepository;
import com.guilhermemc.wrkshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("03/04/2023"), "Partiu viajem","vou viajar para goiania, abracos! ", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("04/04/2023"), "Bom dia","o palmeiras nao tem mundial! ", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("enjoy my friend! ", sdf.parse("04/04/2023"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("I miss u ", sdf.parse("03/04/2023"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Have a good travel ", sdf.parse("05/04/2023"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);
	}

}
