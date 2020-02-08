package com.rjdb.rjdbauth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjdb.rjdbauth.Repository.TopicRepository;
import com.rjdb.rjdbauth.model.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.TopicService#getAllTopics()
	 */
	@Override
	public List<Topic> getAllTopics(){		
		return (List<Topic>) topicRepository.findAll();
	}
	
	
	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.TopicService#getTopic(java.lang.String)
	 */
	@Override
	public Topic getTopic(String id) {
		 return topicRepository.findById(id).get();
	}
	
	@Override
	public Topic getTopicByName(String name) {
		 return topicRepository.findByName(name);
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.TopicService#addTopic(com.rjdb.rjdbauth.model.Topic)
	 */
	@Override
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.TopicService#updateTopic(java.lang.String, com.rjdb.rjdbauth.model.Topic)
	 */
	@Override
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.TopicService#deleteTopic(java.lang.String)
	 */
	@Override
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
