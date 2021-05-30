package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private Game game;

    public Game getGame() {
        return game;
    }

    @Resource
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String getMainMessage() {
        return String.format("Number is between %s and %s. Can you guess it?"
                , getGame().getSmallest()
                , getGame().getBiggest());
    }

    @Override
    public String getResultMessage() {
        if (getGame().isGameWon()){
            return String.format("You guessed it! The number was %s"
                    ,getGame().getNumber());
        }else if (getGame().isGameLost()){
            return String.format("You lost! The number was %s"
                    ,getGame().getNumber());
        }else if(!getGame().isValidNumberRange()){
            return "Invalid Number range";
        } else if (getGame().getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess ?";
        } else {
            String direction = "Lower";

            if (getGame().getGuess() < getGame().getNumber()){
                direction = "Higher";
            }

            return String.format("%s! You have %s remaining guesses "
                    , direction
                    ,getGame().getRemainingGuesses());
        }
    }
}
