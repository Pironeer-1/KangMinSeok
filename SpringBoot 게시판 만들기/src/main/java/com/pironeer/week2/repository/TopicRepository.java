package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap = new HashMap<Long, Topic>();

    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<Long, Comment>();

    public void save(Topic topic) {
        if(topic.getId() == null) {
            Long id = topicIdxGenerator.incrementAndGet();
            topic.setId(id);
            topicMap.put(id, topic);
        }
    }

    public Topic findById(long id) {
        return topicMap.get(id);
    }

    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }

    public void update(Topic topic) {
        topicMap.replace(topic.getId(), topic);
    }

    public void delete(long id) {
        topicMap.remove(id);
    }

    public void createComment(Comment comment) {
        Long id = commentIdxGenerator.incrementAndGet();
        comment.setId(id);
        commentMap.put(id, comment);
    }

}
