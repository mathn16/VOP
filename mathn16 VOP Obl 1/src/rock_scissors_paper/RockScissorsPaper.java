/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_scissors_paper;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Thisen
 */
public class RockScissorsPaper {
    
    private String player;
    private String computer;
    private boolean playing = true;
    
    public final static String[] HANDS = new String[]{"Sten","Saks","Papir"};

    /**
     * @return the player
     */
    public String getPlayer() {
        return player;
    }

    /**
     * @return the computer
     */
    public String getComputer() {
        return computer;
    }
    
    public void play(String playerHand){
        computer = HANDS[new Random().nextInt(3)];
        for(int i = 0; i<HANDS.length; i++){
            if(playerHand == HANDS[i]){
                player = HANDS[i];
            }
        }
    }
    
    public String getWinner(){
        String winner ="";
        String playerWin = "Du vinder!";
        String computerWin = "Computeren vinder!";
        String noWin = "Uafgjort!";
        
        if(player == HANDS[0]){
            if(computer == HANDS[0]){
                winner = noWin;
            }else if(computer == HANDS[1]){
                winner = playerWin;
            }else{
                winner = computerWin;
            }
        }else if(player == HANDS[1]){
            if(computer == HANDS[0]){
                winner = computerWin;
            }else if(computer == HANDS[1]){
                winner = noWin;
            }else{
                winner = playerWin;
            }
        }else if(player == HANDS[2]){
            if(computer == HANDS[0]){
                winner = playerWin;
            }else if(computer == HANDS[1]){
                winner = computerWin;
            }else{
                winner = noWin;
            }
        }
        return winner;
    }
}
