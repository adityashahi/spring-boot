package com.rjdb.rjdbauth.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjdb.rjdbauth.Repository.TopicRepository;
import com.rjdb.rjdbauth.model.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){		
		return (List<Topic>) topicRepository.findAll();
	}
	
	public Topic getTopic(String id) {
		 return topicRepository.findById(id).get();
	}
	
	public Topic getTopicByName(String name) {
		 return topicRepository.findByName(name);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
