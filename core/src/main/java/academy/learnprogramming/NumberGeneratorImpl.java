package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    private final Random RANDOM = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    @Override
    public int next() {

        return RANDOM.nextInt(getMaxNumber() - getMinNumber()) +  getMinNumber();
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
