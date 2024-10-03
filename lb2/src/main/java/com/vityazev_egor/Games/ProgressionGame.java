package com.vityazev_egor.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.vityazev_egor.Models.IGame;
import com.vityazev_egor.Models.Question;

public class ProgressionGame implements IGame {

    private final Integer MAX_START_VALUE = 5;
    private final Integer MIN_COEFFICIENT = 2;
    private final Integer MAX_COEFFICIENT = 5;
    private final Integer PROGRESSION_LENGTH = 8;
    private final Integer BREAK_VALUE = 20000;

    private final Random random = new Random();

    @Override
    public String getName() {
        return "What number is missing in the progression?";
    }

    @Override
    public Question genQuestion() {
        var koef = random.nextInt(MIN_COEFFICIENT, MAX_COEFFICIENT + 1);
        var progression = generateProgression(koef);

        var answerIndex = selectAnswerIndex(progression);
        var correctAnswer = progression.get(answerIndex);

        progression.set(answerIndex, -1);

        var result = new Question();
        result.setCorrectAnswer(correctAnswer);
        result.setQuestion(progression.toString().replace("-1", "..."));

        return result;
    }

    private List<Integer> generateProgression(int koef) {
        var progression = new ArrayList<Integer>();
        progression.add(random.nextInt(1, MAX_START_VALUE + 1));

        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            var nextValue = progression.get(i - 1) * koef;
            if (nextValue >= BREAK_VALUE) {
                break;
            }
            progression.add(nextValue);
        }

        return progression;
    }

    private int selectAnswerIndex(List<Integer> progression) {
        return random.nextInt(progression.size());
    }
}
