package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game{

    private final static Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    private NumberGenerator numberGenerator;

    private int guessCount = 10;
    private int number;
    private int guess;
    private int smaller;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smaller;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @PostConstruct
    @Override
    public void reset() {
        smaller = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNumberRange){
            if (guess > number){
                biggest = guess - 1;
            }
            if (guess < number){
                smaller = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return isValidNumberRange();
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange(){
        validNumberRange = (guess >= smaller) && (guess <= biggest);
    }

    @Override
    public String toString() {
        return "GameImpl{" +
                "numberGenerator=" + numberGenerator +
                ", guessCount=" + guessCount +
                ", number=" + number +
                ", guess=" + guess +
                ", smaller=" + smaller +
                ", biggest=" + biggest +
                ", remainingGuesses=" + remainingGuesses +
                ", validNumberRange=" + validNumberRange +
                '}';
    }
}
