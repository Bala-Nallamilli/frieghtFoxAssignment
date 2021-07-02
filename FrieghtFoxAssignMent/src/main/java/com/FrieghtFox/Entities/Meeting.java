package com.FrieghtFox.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Meeting")
@Data
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long meeting_id;
	
	@Column(nullable = false)
	private String meeting_title;
	
	private String meeting_description;
	
	@Column(nullable = false)
	private Date startTime;
	
	@Column(nullable = false)
	private Date endTime;
	

	
	public Meeting() {
		
	}


	public Meeting(Long meeting_id, String meeting_title, String meeting_description, Date startTime, Date endTime) {
		super();
		this.meeting_id = meeting_id;
		this.meeting_title = meeting_title;
		this.meeting_description = meeting_description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getMeeting_id() {
		return meeting_id;
	}


	public void setMeeting_id(Long meeting_id) {
		this.meeting_id = meeting_id;
	}


	public String getMeeting_title() {
		return meeting_title;
	}


	public void setMeeting_title(String meeting_title) {
		this.meeting_title = meeting_title;
	}


	public String getMeeting_description() {
		return meeting_description;
	}


	public void setMeeting_description(String meeting_description) {
		this.meeting_description = meeting_description;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "Meeting [id=" + meeting_id + ", meeting_title=" + meeting_title + ", meeting_description=" + meeting_description
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
