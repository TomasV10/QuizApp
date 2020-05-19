package Services;


import com.practise.quiz.entities.Answer;
import com.practise.quiz.entities.Question;
import com.practise.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public int findAnswerIdCorrect(int questionId){
        Question question = questionRepository.findById(questionId).get();
        for(Answer answer : question.getAnswers()){
            if(answer.isCorrect()){
                return answer.getId();
            }
        }
        return -1;
    }

}
