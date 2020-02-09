package com.rjdb.rjdbauth.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rjdb.rjdbauth.controller.TopicsController;
import com.rjdb.rjdbauth.model.Topic;
import com.rjdb.rjdbauth.service.TopicServiceImpl;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TopicsController.class)
public class TopicControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc; 
	
	@MockBean
	private TopicServiceImpl topicService;
	
	
	@Test
	public void givenTopic_whenGetTopics_thenReturnJsonArray()
	  throws Exception {
	     
	    Topic topic = new Topic("alex","topicNew","greate description of alex");
	 
	    List<Topic> allTopics = Arrays.asList(topic);
	 
	    when(topicService.getAllTopics()).thenReturn(allTopics);
	 
	    mvc.perform(get("/v1/topics")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$[0].id", is(topic.getId())));
	}
}
