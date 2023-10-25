package org.example.Tennis;

import junit.framework.TestCase;
import org.example.Tennis.Game;
import org.example.Tennis.Player;

public class GameTest extends TestCase {

    public void test_get_default_score_love_love(){
        //Given
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);
        //When
        String score = game.getScore();
        //Then
        assertEquals("love-love", score);
    }

    public void test_player1_with_score_love_win(){
        //Given
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("15-love", score);
    }

    public void test_player1_with_score_15_win(){
        //Given
        Player player1 = new Player("player1", 1);
        Player player2 = new Player("player2", 0);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("30-love", score);
    }

    public void test_player1_with_score_30_win(){
        //Given
        Player player1 = new Player("player1", 2);
        Player player2 = new Player("player2", 0);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("40-love", score);
    }

    public void test_player1_with_score_40_win(){
        //Given
        Player player1 = new Player("player1", 3);
        Player player2 = new Player("player2", 0);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("player1 win", score);
    }

    //
    public void test_player2_with_score_40_and_player1_with_score_30_win_return_Deuce(){
        //Given
        Player player1 = new Player("player1", 2);
        Player player2 = new Player("player2", 3);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("Deuce", score);
    }

    public void test_Avantage_Player_1(){
        //Given
        Player player1 = new Player("player1", 3);
        Player player2 = new Player("player2", 3);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("ADVANTAGE player1", score);
    }

    public void test_player2_with_score_ADVANTAGE_and_player1_with_score_40_win_return_Deuce(){
        //Given
        Player player1 = new Player("player1", 3);
        Player player2 = new Player("player2", 4);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer1());
        String score = game.getScore();
        //Then
        assertEquals("Deuce", score);
    }

    public void test_player2_with_score_ADVANTAGE_win(){
        //Given
        Player player1 = new Player("player1", 3);
        Player player2 = new Player("player2", 4);
        Game game = new Game(player1, player2);
        //When
        game.marquePoint(game.getPlayer2());
        String score = game.getScore();
        //Then
        assertEquals("player2 win", score);
    }

    public void test_play_one_set() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);

        System.out.println();
        String score = game.getScore();
        assertEquals("love-love", score);

        game.marquePoint(game.getPlayer1());
        score = game.getScore();
        assertEquals("15-love", score);

        game.marquePoint(game.getPlayer1());
        score = game.getScore();
        assertEquals("30-love", score);

        game.marquePoint(game.getPlayer1());
        score = game.getScore();
        assertEquals("40-love", score);

        game.marquePoint(game.getPlayer1());
        score = game.getScore();
        assertEquals("player1 win", score);

    }


}