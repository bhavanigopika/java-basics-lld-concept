package tictactoe.factory;

import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.botwinningstrategies.BotWinningStrategy;
import tictactoe.strategies.botwinningstrategies.EasyBotWinningStrategy;
import tictactoe.strategies.botwinningstrategies.HardBotWinningStrategy;
import tictactoe.strategies.botwinningstrategies.MediumBotWinningStrategy;

public class BotPlayingStrategyFactory {
    //provides the BotWinningStrategy
    public static BotWinningStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotWinningStrategy();
        } else if(botDifficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotWinningStrategy();
        } else{
            return new HardBotWinningStrategy();
        }
    }
}
