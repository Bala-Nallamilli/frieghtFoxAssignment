package com.FrieghtFox.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FrieghtFox.Entities.Meeting;
import com.FrieghtFox.Entities.User;
import com.FrieghtFox.Repository.MeetingRepository;
import com.FrieghtFox.Repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	
	public User addUser(User user) {
		user.getMeetings().stream().forEach(m -> {
			this.meetingRepository.save(m);
		});
		return this.userRepository.save(user);	
	}
	
	public User updateStatus(Long userId,Integer status) {
		Optional<User> optionaluser = userRepository.findById(userId);
		if(status >= 1 && status <= 3) {
			if(optionaluser.isPresent()) {
				User usr = optionaluser.get();
				usr.setMeetingInvitationstatus(status);
				return this.userRepository.save(usr);
			}
		}
		
		throw new RuntimeException("invalid status status should be betwwen 1-3");
	}
	
	public User addMeeting(Long userId,Meeting meeting) {
		Optional<User> optionaluser = userRepository.findById(userId);
		if(optionaluser.isPresent()) {
			User user = optionaluser.get();
			user.getMeetings().add(meeting);
			this.userRepository.save(user);
			this.meetingRepository.save(meeting);
			return user;
		}
		
		throw new RuntimeException("invalid request please check the requst body and user id");
	}
	
	public List<User> getUsersWithInvitationsAccepted(){
		return this.userRepository.
					findAll().stream()
					.filter( u -> u.getMeetingInvitationstatus() == User.ACCEPTED)
					.collect(Collectors.toList());
	}
	
	
	public List<User> getUsersWithInvitationsPending(){
		return this.userRepository.
					findAll().stream()
					.filter( u -> u.getMeetingInvitationstatus() == User.INVITED)
					.collect(Collectors.toList());
	}
	
	public List<User> getUsersWithInvitationsRejected(){
		return this.userRepository.
					findAll().stream()
					.filter( u -> u.getMeetingInvitationstatus() == User.REJECTED)
					.collect(Collectors.toList());
	}
	

}
