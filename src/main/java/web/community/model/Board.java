package web.community.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board {

	private int num;
	private String title;
	private String content;
	private String writer_id;
	private String files;
	private String hit;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date regdate;
	private int cmt_count;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCmt_count() {
		return cmt_count;
	}
	public void setCmt_count(int cmt_count) {
		this.cmt_count = cmt_count;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", writer_id=" + writer_id
				+ ", files=" + files + ", hit=" + hit + ", regdate=" + regdate + ", cmt_count=" + cmt_count + "]";
	}
	
	
}
