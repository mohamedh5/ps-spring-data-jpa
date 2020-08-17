package com.pluralsight.conferencedemo.repositories;

import java.util.List;

import com.pluralsight.conferencedemo.models.Speaker;



public interface SpeakerCustomRepository {

	List<Speaker> findAllFristName(String name);
}
