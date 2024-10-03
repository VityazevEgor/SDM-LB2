package com.vityazev_egor.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String question;
    private Integer correctAnswer;

    public Boolean checkAnswer(String rawAnswer){
        try{
            Integer answer = Integer.parseInt(rawAnswer.replace(" ", ""));
            return correctAnswer.equals(answer);
        } catch (NumberFormatException e){
            return false;
        }
    }
}
