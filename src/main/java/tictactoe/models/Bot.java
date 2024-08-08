package tictactoe.models;

import tictactoe.factory.BotPlayingStrategyFactory;
import tictactoe.strategies.botwinningstrategies.BotWinningStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botPlayingStrategy;

    /*
    Bot extends Player so, bot is a children of parent and bot include the attributes of parent (i.e) player...so use super keyword...
    Someone creates a bot with
    Bot bot = new Bot(nameOfTheBot(note: here bot is also a player), symbol, don't add player type...because playerType will be bot only, botDifficultyLevel, botPlayingStrategy)
    (i.e)
    Bot bot = new Bot(name, symbol, botDifficultyLevel, botPlayingStrategy);
     */
    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel/*, BotWinningStrategy botPlayingStrategy*/){
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        //this.botPlayingStrategy = botPlayingStrategy;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotWinningStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotWinningStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    //makeMove happened in Players.java also...so override here
    @Override
    public Move makeMove(Board board){
        Move move = botPlayingStrategy.makeMove(board);
        return move;
    }
}
