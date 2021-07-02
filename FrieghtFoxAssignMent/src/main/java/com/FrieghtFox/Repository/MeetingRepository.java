package com.FrieghtFox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FrieghtFox.Entities.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
