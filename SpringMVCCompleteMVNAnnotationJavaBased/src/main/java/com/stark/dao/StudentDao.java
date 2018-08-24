package com.stark.dao;

import com.stark.model.StudentDetail;

public interface StudentDao {

	void registerStudent(StudentDetail student);

	StudentDetail loginStudent(String name, String password);

}