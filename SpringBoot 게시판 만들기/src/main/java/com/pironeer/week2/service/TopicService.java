package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request){
        Topic topic = Topic.builder()
                        .title(request.title())
                        .content(request.content())
                        .createdAt(now())
                        .updatedAt(now())
                        .build();
        topicRepository.save(topic);
    }

    public TopicResponse findById(Long id){
        Topic topic = topicRepository.findById(id);
        if(topic == null){ // 없을 경우 언체크 예외 던짐
            throw new RuntimeException("Topic Not Found");
        }
        return TopicResponse.of(topic);
    }

    public List<TopicResponse> findAll(){
        List<Topic> topics =  topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    public TopicResponse update(TopicUpdateRequest request){
        Topic topic = topicRepository.findById(request.id()); // 아이디에 맞는 topic 가져옴
        if(topic == null){ // 없을 경우 언체크 예외 던짐
            throw new RuntimeException("Topic Not Found");
        }
        topic.setTitle(request.title()); // topic의 제목, 내용, 업데이트 날짜 변경
        topic.setContent(request.content());
        topic.setUpdatedAt(now());
        topicRepository.update(topic); // 변경된 topic을 repository에도 update
        return TopicResponse.of(topic);
    }

    public void deleteById(Long id){
        Topic topic = topicRepository.findById(id); // 아이디에 맞는 topic 가져옴
        if(topic == null){ // 없을 경우 언체크 예외 던짐
            throw new RuntimeException("Topic Not Found");
        }
        topicRepository.delete(id);
    }

    public CommentResponse createComment(Long topicId, CommentCreateRequest request){
        Comment comment = Comment.builder()
                .content(request.content())
                .topicId(topicId)
                .parentId(request.parentId())
                .createdCommentAt(now())
                .build();
        topicRepository.createComment(comment);
        return CommentResponse.of(comment);
    }

}
