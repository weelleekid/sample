package com.project.sample.domain;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.*;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.sample.domain.posts.Posts;
import com.project.sample.domain.posts.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;
	
	@After(value = "")
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void call() {

		//given
		postsRepository.save(Posts.builder().title("테스트").content("테스트본문").author("shineest96@gmail.com").build());

		//when
		List<Posts> postsList = postsRepository.findAll();

		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(),is("테스트"));
		assertThat(posts.getContent(),is("테스트본문"));
	}
}
