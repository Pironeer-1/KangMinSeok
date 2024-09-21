package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/topic")
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponse>> findAll() { //전체 조회
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request){ // 저장
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id){ // 특정 topic 조회
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/update")
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdateRequest request){ // topic 변경
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/delete/{topicId}")
    public ResponseEntity<?> delete(@PathVariable("topicId") Long id){ // topic 삭제
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("comment/{topicId}") //댓글 및 대댓글 달기
    public ResponseEntity<CommentResponse> comment(@PathVariable("topicId") Long topicId, @RequestBody CommentCreateRequest request){
        CommentResponse response = topicService.createComment(topicId, request);
        return ResponseEntity.ok().body(response);
    }

}
