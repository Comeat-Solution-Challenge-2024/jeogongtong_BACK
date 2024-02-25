package com.comeat.jeogongtong.service;

import com.comeat.jeogongtong.dto.AnswerRequestDto;
import com.comeat.jeogongtong.dto.AnswerResponseDto;
import com.comeat.jeogongtong.dto.QuestionRequestDto;
import com.comeat.jeogongtong.dto.QuestionResponseDto;
import com.comeat.jeogongtong.model.Answers;
import com.comeat.jeogongtong.model.Questions;
import com.comeat.jeogongtong.model.Users;
import com.comeat.jeogongtong.repository.AnswersRepository;
import com.comeat.jeogongtong.repository.QuestionsRepository;
import com.comeat.jeogongtong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswersService {
    private final AnswersRepository answersRepository;
    private final UserRepository userRepository;

    // 수정
    @Transactional
    public AnswerResponseDto awrite(AnswerRequestDto requestDto){
        Answers answers = requestDto.toEntity();
        Answers savedAnswer = answersRepository.save(answers);
        // 답변 작성 후 포인트 지급
        Users user = savedAnswer.getUsers();
        user.addPoints(100);
        userRepository.save(user);

        return AnswerResponseDto.of(savedAnswer);
    }

    @Transactional
    public AnswerResponseDto updateAWrite(Long id, AnswerRequestDto requestDto) {
        Answers exanswers = answersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        BeanUtils.copyProperties(requestDto, exanswers, "id");
        Answers updatedAnswers = answersRepository.save(exanswers);

        return AnswerResponseDto.of(updatedAnswers);
    }
    @Transactional
    public void deleteAWrite(Long id) {
        answersRepository.deleteById(id);
    }

}
