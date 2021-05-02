package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random RANDOM = new Random();
    private int maxNumber = 100;

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public int next() {
        return RANDOM.nextInt(getMaxNumber());
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }
}
