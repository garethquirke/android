package ca1.moneyconversionapp;

import java.util.ArrayList;

/**
 * Created by garet on 05/04/2017.
 */

public class Money {

    public ArrayList<Coin> Coins;
    public ArrayList<Note> Notes;


    public Money(){
        Coins = new ArrayList<Coin>();
        Notes = new ArrayList<Note>();
    }


    public void setCoins(ArrayList<Coin> coins){
        this.Coins = coins;
    }

    public void setNotes(ArrayList<Note> notes){
        this.Notes = notes;
    }

    public ArrayList<Coin> getCoins(){
        return Coins;
    }

    public ArrayList<Note> getNotes(){
        return Notes;
    }


    public String Print(){
        String output= "";

        for(int i = 0; i < Notes.size(); i++){

            if((Notes.get(i).getType() == NoteType.fifty) && (Notes.get(i).getQty() !=0)){
                output += Notes.get(i).getQty() + " x €50" + "\n";
            }
            else if((Notes.get(i).getType() == NoteType.twenty) && (Notes.get(i).getQty() !=0)){
                output += " " + Notes.get(i).getQty() + " x €20" + "\n";
            }
            else if((Notes.get(i).getType() == NoteType.ten) && (Notes.get(i).getQty() !=0)){
                output +=  " " + Notes.get(i).getQty() + " x €10" + "\n";
            }
            else if((Notes.get(i).getType() == NoteType.five) && (Notes.get(i).getQty() !=0)){
                output += " " + Notes.get(i).getQty() + " x €5" + "\n";
            }
        }

        for(int i = 0; i < Coins.size(); i++){
            if((Coins.get(i).getType() == CoinType.two) && (Coins.get(i).getQty() !=0)){
                output += " " + Coins.get(i).getQty() + " x €2" + "\n";
            }
            else if((Coins.get(i).getType() == CoinType.one) && (Coins.get(i).getQty() !=0)){
                output += " " + Coins.get(i).getQty() + " x €1" + "\n";
            }
            else if((Coins.get(i).getType() == CoinType.fifty) && (Coins.get(i).getQty() !=0)){
                output += " " + Coins.get(i).getQty() + " x €0.50" + "\n";
            }
            else if((Coins.get(i).getType() == CoinType.twenty) && (Coins.get(i).getQty() !=0)){
                output += " " + Coins.get(i).getQty() + " x €0.20" + "\n";
            }
            else if((Coins.get(i).getType() == CoinType.ten) && (Coins.get(i).getQty() !=0)){
                output += " " + Coins.get(i).getQty() + " x €0.10" + "\n";
            }
            else if((Coins.get(i).getType() == CoinType.five) && (Coins.get(i).getQty() !=0)) {
                output += " " + Coins.get(i).getQty() + " x €0.05" + "\n";
            }
        }

        return output;
    }


    public  Money ConvertCents(int total){
        Money output = new Money();

        int fifties = total / 5000;
        output.Notes.add(new Note(NoteType.fifty, fifties));
        int leftover = total % 5000;

        int twenties = leftover / 2000;
        output.Notes.add(new Note(NoteType.twenty, twenties));
        leftover = leftover % 2000;

        int tens = leftover / 1000;
        output.Notes.add(new Note(NoteType.ten, tens));
        leftover = leftover % 1000;

        int fives = leftover / 500;
        output.Notes.add(new Note(NoteType.five, fives));
        leftover = leftover % 500;

        int twos = leftover / 200;
        output.Coins.add(new Coin(CoinType.two, twos));
        leftover = leftover % 200;

        int ones = leftover / 100;
        output.Coins.add(new Coin(CoinType.one, ones));
        leftover = leftover % 100;

        int fiftyCents = leftover / 50;
        output.Coins.add(new Coin(CoinType.fifty, fiftyCents));
        leftover = leftover % 50;

        int tenCents = leftover / 10;
        output.Coins.add(new Coin(CoinType.ten, tenCents));
        leftover = leftover % 10;

        int fiveCents = leftover / 5;
        output.Coins.add(new Coin(CoinType.five, fiveCents));
        leftover = leftover % 5;


        return output;
    }
}
