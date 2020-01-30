package com.WebBlog.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogController 
{
	public Blog blog;
	
	public static Map<String, Blog> BlogById = new HashMap<>();
	{
		Blog user=new Blog();
		user.setId("1");
		user.setAuthor("pramod");
		user.setContent("this is the blog implemented by spring boot");
		BlogById.put(Blog.getId(), user);
		
		
	}
	
	@RequestMapping(value="/getBlog", method=RequestMethod.GET)
	public ResponseEntity<Object> getBlog(@RequestParam() String id) throws Exception
	{
		Object bog = BlogById.get(id);
	     
	    if(bog == null) {
	         throw new Exception("Invalid Blog id : " + id);
	    }
		return new ResponseEntity<>( BlogById.getOrDefault(id, blog), HttpStatus.OK);

	}
	
	@RequestMapping(value="/createBlog", method=RequestMethod.POST)
	public ResponseEntity<Object> createBlog(@RequestBody Blog blog)
	{
		BlogById.put(Blog.getId(), blog);
		return new ResponseEntity<>("blog is created successfully", HttpStatus.CREATED);
	}
	

}
