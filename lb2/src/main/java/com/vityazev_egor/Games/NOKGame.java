package com.vityazev_egor.Games;

import com.vityazev_egor.Models.IGame;
import com.vityazev_egor.Models.Question;

import java.util.*;

public class NOKGame implements IGame {
    private final Random random = new Random();

    @Override
    public String getName() {
        return "Find the smallest common multiple of given numbers.";
    }

    @Override
    public Question genQuestion() {
        Set<Integer> values = new HashSet<>();
        while (values.size() != 3) {
            values.add(random.nextInt(2,21));
        }
        return new Question(values.toString(), findAnswer(values));
    }

    private Integer findAnswer(Set<Integer> values) {
        Integer startValue = Collections.max(values);
        
        for (Integer currentValue = startValue; currentValue < Integer.MAX_VALUE; currentValue++) {
            if (isCommonMultiple(currentValue, values)) {
                return currentValue;
            }
        }
        return 0;
    }
    
    private Boolean isCommonMultiple(Integer currentValue, Set<Integer> values) {
        for (Integer value : values) {
            if (currentValue % value != 0) {
                return false;
            }
        }
        return true;
    }    
    
}
