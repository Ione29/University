public class Account {
    
    private String IBAN;
    private Currency currency;
    private Double sum;
    
    public Account(String vIBAN, Currency vCurrency, double vSum){
        this.IBAN = vIBAN;
        this.currency = vCurrency;
        this.sum = vSum;
    }

    public String getIBAN(){
        return this.IBAN;
    }

    public Currency getCurrency(){
        return this.currency;
    }

    public Double getSum(){
        return this.sum;
    }

    public Double getConvertedFromRON(){
        return this.sum * 4.95;
    }

    public Double getConvertedFromUSD(){
        return this.sum * 1.02;
    }
}
