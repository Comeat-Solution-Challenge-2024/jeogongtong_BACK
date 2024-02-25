package com.comeat.jeogongtong.controller;

import com.comeat.jeogongtong.dto.ApplyResponseDto;
import com.comeat.jeogongtong.dto.RegistRequestDto;
import com.comeat.jeogongtong.dto.StudyDto;
import com.comeat.jeogongtong.service.StudyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/study-clubs")
public class StudyController {
    private final StudyService studyService;

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestBody RegistRequestDto registRequestDto) {

        studyService.regist(registRequestDto);
        return ResponseEntity.ok("스터디 등록 완료");
    }

    @PostMapping("/search")
    public ResponseEntity<List<StudyDto>> search(@RequestParam String keyword) {
        List<StudyDto> studyList = studyService.search(keyword);

        return ResponseEntity.ok(studyList);
    }

    @GetMapping("/apply/{studyId}") //ok
    public ResponseEntity<ApplyResponseDto> apply(@PathVariable Long studyId){
        StudyDto studyDto = studyService.findById(studyId);
        ApplyResponseDto applyResponseDto = new ApplyResponseDto();
        BeanUtils.copyProperties(studyDto,applyResponseDto); //스터디 정보를 ApplyResponseDto로 복사
        return ResponseEntity.ok(applyResponseDto);
    }
}

