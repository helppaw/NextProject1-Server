package com.revature.daos;

import java.util.List;

import com.revature.models.QuizJoin;
import com.revature.daos.QuizJoinDaoSQL;

public interface QuizJoinDao {

	QuizJoinDao currentImplementation = new QuizJoinDaoSQL();

	
	int save(QuizJoin r);
	
	int update(QuizJoin r);

	List<QuizJoin> findAll();

	List<QuizJoin> findByAuthorName(String name);

	List<QuizJoin> findByAuthorId(int reimbAuthor);

	List<QuizJoin> findByStatusId(int reimbStatusId);

	QuizJoin findById(int reimbId);

	void release(int pokemonId);

}
