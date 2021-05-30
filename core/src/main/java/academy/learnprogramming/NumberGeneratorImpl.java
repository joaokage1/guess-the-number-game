package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random RANDOM = new Random();

    private final int maxNumber;

    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

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
