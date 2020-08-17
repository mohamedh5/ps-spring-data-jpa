package com.pluralsight.conferencedemo.repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pluralsight.conferencedemo.models.Speaker;

@Repository
public class SpeakerRepository {
	@Autowired
	private SpeakerJpaRepository speakerRepo;

	@Transactional
	public Speaker create(Speaker speaker) {
		speakerRepo.save(speaker);
		speakerRepo.addlog();
		return speaker;
	}

	public Speaker update(Speaker speaker) {
		speaker = speakerRepo.save(speaker);
		speakerRepo.addlog();
		return speaker;
	}

	public void delete(Long id) {
		speakerRepo.delete(find(id));
	}

	public Speaker find(Long id) {
		return speakerRepo.findById(id).get();
	}

	public List<Speaker> list() {
		return StreamSupport.stream(speakerRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	public List<Speaker> findAllByName(String name){
		return speakerRepo.findAllFristName(name);
	}
}
