/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_scissors_paper;

import java.util.InputMismatchException;
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
    private int valg;
    
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
    public static void main(String[] args){
        RockScissorsPaper rSP = new RockScissorsPaper();
        Scanner input = new Scanner(System.in);
        
        while(rSP.playing){
            System.out.println("[0]Sten, [1]Saks or [2]Papir ?");
            rSP.valg = input.nextInt();
            if(rSP.valg != 0 && rSP.valg != 1 && rSP.valg != 2){
                rSP.playing = false;
                System.out.println("Tak for spillet!");
            }else{
                rSP.play(HANDS[rSP.valg]);
                System.out.println(rSP.getWinner()+"\n\nDu valgte:\n" + rSP.getPlayer() +"\nComputeren valgte:\n" + rSP.getComputer());
            }
        }
    }
}
