package edu.pnu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Comment;
import edu.pnu.dto.CommentDto;
import edu.pnu.service.CommentService;
import lombok.RequiredArgsConstructor;

//URL 프리픽스 고정
@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {
	
	private final CommentService answerService;
	
	@GetMapping("/list1")
	public List<Comment> list(){
		return answerService.getList();
	}
	
	@GetMapping("/list")
	public List<CommentDto> list1(){
		return answerService.getList1();
	}
	
	//id는 게시글 번호
	@GetMapping("/boardComment/{id}")
	public List<CommentDto> listTest(@PathVariable Integer id){
		return answerService.getComment(id);
	}
	
	//id는 게시글 번호
	@PostMapping("/create/{id}")
	public void createAnswer(@PathVariable Integer id, @RequestBody CommentDto dto) {
		answerService.addComment(id, dto);
	}
	
	
	// controller에서 void로 반환하면 프론트에 가는게 없음
	// dto 는 어디서 받아오는가?
//	@PostMapping("/create/{id}")
//	public ResponseEntity<?> createAnswer(@PathVariable Integer id, @RequestBody String text){
//		Comment comment = answerService.addComment(id, text);
//		return ResponseEntity.ok(comment);
//	}
	
	//id 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnswerBoard(@PathVariable Integer id){
		answerService.deleteComment(id);
		return ResponseEntity.ok("delete successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> UpdateAnswerBoard(@PathVariable Integer id,@RequestBody CommentDto dto){
		answerService.updateComment(id,dto);
		return ResponseEntity.ok("update successfully");
	}
	
	

}