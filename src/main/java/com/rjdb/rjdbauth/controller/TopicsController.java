package com.rjdb.rjdbauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rjdb.rjdbauth.model.Topic;
import com.rjdb.rjdbauth.service.TopicServiceImpl;

@RestController
@RequestMapping("/v1")
public class TopicsController {
	
	@Autowired
	private TopicServiceImpl topicServiceImpl;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicServiceImpl.getAllTopics();
		}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicServiceImpl.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicServiceImpl.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicServiceImpl.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicServiceImpl.deleteTopic(id);
	}
}
