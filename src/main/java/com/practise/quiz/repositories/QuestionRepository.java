package com.practise.quiz.repositories;

import com.practise.quiz.entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
