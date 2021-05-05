package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    @PostConstruct
    public void postConstructorMessage(){
        log.info("Game class: {}", getGame().toString());
    }

    @PreDestroy
    public void preDestroy(){
        log.info("MessageGenerator preDestroy()");
    }

    @Override
    public String getMainMessage() {
        return "";
    }

    @Override
    public String getResultMessage() {
        return " ";
    }
}
