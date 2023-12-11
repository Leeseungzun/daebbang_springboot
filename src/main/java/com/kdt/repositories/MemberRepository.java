package com.kdt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kdt.domain.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	@Query("select m from Member m where m.email = ?1")
	List<Member> selectbyemail(String email);

}
