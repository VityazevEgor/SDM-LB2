package com.vityazev_egor.Games;

import com.vityazev_egor.Models.IGame;
import com.vityazev_egor.Models.Question;

import java.util.*;

public class NOKGame implements IGame {
    private final Random r = new Random();

    @Override
    public String getName() {
        return "Find the smallest common multiple of given numbers.";
    }

    @Override
    public Question genQuestion() {
        Set<Integer> values = new HashSet<>();
        while (values.size() != 3) {
            values.add(r.nextInt(2,100));
        }
        return new Question(values.toString(), findAsnwer(values).toString());
    }

    private Integer findAsnwer(Set<Integer> values){
        Integer startValue = Collections.max(values);
        for (Integer currentValue = startValue; currentValue<Integer.MAX_VALUE; currentValue++){
            Boolean foundAnswer = true;
            for (Integer value : values) {
                if (currentValue % value != 0){
                    foundAnswer = false;
                    break;
                }
            }
            if (foundAnswer) return currentValue;
        }
        return 0;
    }
    
}
