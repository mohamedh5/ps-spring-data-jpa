package com.pluralsight.conferencedemo.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyJpaRepository<T, ID> extends CrudRepository<T, ID>{

	@Modifying
	@Query(value = "insert into Log (id,Date)"
			+ "Values(1,current_date())", nativeQuery = true)
	void addlog();
}
