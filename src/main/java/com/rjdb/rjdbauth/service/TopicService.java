package com.rjdb.rjdbauth.service;

import java.util.List;

import com.rjdb.rjdbauth.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();

	Topic getTopic(String id);

	void addTopic(Topic topic);

	void updateTopic(String id, Topic topic);

	void deleteTopic(String id);

	Topic getTopicByName(String name);

}