package com.FrieghtFox.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

	public static Integer ACCEPTED = 1;
	public static Integer INVITED = 2;
	public static Integer REJECTED = 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "meeting_id")
	private Set<Meeting> meetings = new HashSet<>();
	
	@Column(nullable = false)
	private Integer meetingInvitationstatus;
	
	public User() {
		
	}

	public User(Long user_id, String name, Set<Meeting> meetings, Integer meetingInvitationstatus) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.meetings = meetings;
		this.meetingInvitationstatus = meetingInvitationstatus;
	}

	
	

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

	public Integer getMeetingInvitationstatus() {
		return meetingInvitationstatus;
	}

	public void setMeetingInvitationstatus(Integer meetingInvitationstatus) {
		this.meetingInvitationstatus = meetingInvitationstatus;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + name + ", meetings=" + meetings + ", meetingInvitationstatus="
				+ meetingInvitationstatus + "]";
	}
	
}
