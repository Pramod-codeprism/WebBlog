package com.WebBlog.demo;

import org.springframework.stereotype.Component;

@Component
public class Blog 
{
	private static String id;
	private String author;
	private String content;
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		Blog.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", author=" + author + ", content=" + content + "]";
	}
	

}
