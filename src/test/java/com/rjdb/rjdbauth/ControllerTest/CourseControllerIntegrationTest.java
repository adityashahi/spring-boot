package com.rjdb.rjdbauth.ControllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rjdb.rjdbauth.RjdbAuthApplication;
import com.rjdb.rjdbauth.Repository.CourseRepository;
import com.rjdb.rjdbauth.Repository.TopicRepository;
import com.rjdb.rjdbauth.controller.TopicsController;
import com.rjdb.rjdbauth.model.Topic;
import com.rjdb.rjdbauth.service.TopicServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes=RjdbAuthApplication.class,
		webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class CourseControllerIntegrationTest {

	@Autowired
    private MockMvc mvc;
 
    @Autowired
    private TopicRepository repository;
    
	@Test
    public void givenCourse_whenGetCourses_thenStatus200()
      throws Exception {
    	Topic topic = new Topic("id", "java", "description of java topic");
    	repository.save(topic);
    	
    	mvc.perform(get("/topics")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("java")));
    }
}
