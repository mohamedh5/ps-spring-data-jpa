package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;

public interface SpeakerJpaRepository extends MyJpaRepository<Speaker, Long>, SpeakerCustomRepository{

	
}
