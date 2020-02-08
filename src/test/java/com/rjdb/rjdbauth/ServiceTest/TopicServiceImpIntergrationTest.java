package com.rjdb.rjdbauth.ServiceTest;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.rjdb.rjdbauth.Repository.TopicRepository;
import com.rjdb.rjdbauth.model.Topic;
import com.rjdb.rjdbauth.service.TopicService;
import com.rjdb.rjdbauth.service.TopicServiceImpl;

@RunWith(SpringRunner.class)
public class TopicServiceImpIntergrationTest {

	@TestConfiguration
	static class TopicServiceImplTestContextConfiguration{
		
		@Bean
		public TopicService topicService() {
			return new TopicServiceImpl();
		}
	}
	
	@Autowired
	private TopicService topicService;
	
	@MockBean
	private TopicRepository topicRepository;
	
	
	@Before
	public void setUp() {
	    Topic python = new Topic("id2", "python", "This is an awesome language");
	 
	    Mockito.when(topicRepository.findByName(python.getName()))
	      .thenReturn(python);
	}
	
	
	
	@Test
	public void whenValidName_thenTopicShouldBeFound() {
	    String name = "python";
	    Topic found = topicService.getTopicByName(name);
	     assertThat(found.getName())
	      .isEqualTo(name);
	 }
	
	
}
