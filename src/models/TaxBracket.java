package models;

public class TaxBracket {

    private final double lowTaxBracket;
    private final double highTaxBracket;
    private final double rate;

    public TaxBracket(double lowTaxBracket, double highTaxBracket, double rate) {
        this.lowTaxBracket = lowTaxBracket;
        this.highTaxBracket = highTaxBracket;
        this.rate = rate;
    }

    public double getLowTaxBracket(){
        return lowTaxBracket;
    }

    public double getHighTaxBracket(){
        return highTaxBracket;
    }

    public double getRate(){
        return rate;
    }
}


