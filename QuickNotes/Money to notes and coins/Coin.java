package ca1.moneyconversionapp;

/**
 * Created by garet on 05/04/2017.
 */
enum CoinType {two, one, fifty, twenty, ten, five}
public class Coin {

    public CoinType Type;
    public int Qty;


    public Coin(CoinType type, int qty){
        Type = type;
        Qty = qty;
    }


    public int getQty(){
        return Qty;
    }

    public CoinType getType(){
        return Type;
    }
}
