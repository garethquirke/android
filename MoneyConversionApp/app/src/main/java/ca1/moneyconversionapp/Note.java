package ca1.moneyconversionapp;

/**
 * Created by garet on 05/04/2017.
 */

enum NoteType{fifty, twenty, ten, five}
public class Note {

    public NoteType Type;
    public int Qty;

    public NoteType getType(){
        return Type;
    }

    public int getQty(){
        return Qty;
    }

    public Note(NoteType type, int qty){
        Type = type;
        Qty = qty;
    }
}
