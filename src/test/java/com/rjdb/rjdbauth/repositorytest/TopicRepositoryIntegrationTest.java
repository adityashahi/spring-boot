package com.rjdb.rjdbauth.repositorytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.rjdb.rjdbauth.Repository.TopicRepository;
import com.rjdb.rjdbauth.model.Topic;

@RunWith(SpringRunner.class) 
@DataJpaTest
public class TopicRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private TopicRepository topicRepsitory;
	
	@Test
	public void whenFindByName_thenReturnTopic() {
		//given
		Topic java = new Topic("id", "java", "description of java topic");
		entityManager.persist(java);
		entityManager.flush();
		
		//when
		Topic found = topicRepsitory.findByName(java.getName());
		
		//then
		assertThat(found.getDescription())
		.isEqualTo(java.getDescription());
	}
}

