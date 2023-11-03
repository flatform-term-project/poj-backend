package com.poj.service.problem;

import com.poj.dto.problem.ProblemCreateRequest;
import com.poj.entity.problem.Problem;
import com.poj.repository.problem.ProblemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 문제의 내용을 수정합니다.
 */


@RequiredArgsConstructor
@Transactional
@Service
public class ProblemUpdateService {
    private final ProblemRepository problemRepository;

    public void UpdateProblem(Long ID, ProblemCreateRequest problemCreateRequest){
        if(problemRepository.findById(ID).isPresent()){
            Problem problem = problemRepository.findById(ID).get();
            problem.update(problemCreateRequest);
            problemRepository.save(problem);
        }
    }
}