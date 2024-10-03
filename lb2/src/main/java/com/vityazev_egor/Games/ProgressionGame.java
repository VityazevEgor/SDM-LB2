package com.vityazev_egor.Games;

import com.vityazev_egor.Models.IGame;
import com.vityazev_egor.Models.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProgressionGame implements IGame {

    private final Integer maxStartValue = 5;
    private final Integer minCoef = 2;
    private final Integer maxCoef = 5;
    private final Integer progressionLength = 8;
    private final Integer breakValue = 20000;

    private final Random random = new Random();

    @Override
    public String getName() {
        return "What number is missing in the progression?";
    }

    @Override
    public Question genQuestion() {
        var koef = random.nextInt(minCoef, maxCoef + 1);
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
        progression.add(random.nextInt(1, maxStartValue + 1));

        for (int i = 1; i < progressionLength; i++) {
            var nextValue = progression.get(i - 1) * koef;
            if (nextValue >= breakValue) {
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
