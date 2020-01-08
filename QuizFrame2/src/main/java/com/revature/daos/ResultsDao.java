package com.revature.daos;
import java.util.List;

import com.revature.models.Results;
public interface ResultsDao {


ResultsDao currentImplementation = new ResultsDaoSQL();


	int save(Results r);
	
	int update(Results r);

	List<Results> findAll();

	List<Results> findByStudentId(int userId);

	List<Results> findById(int resultsId);

	

}
