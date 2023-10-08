import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class User {
    private String username;
    private String email;
    private ArrayList<Account> accounts;

    public User(String vUsername, String vEmail){
        this.username = vUsername;
        this.email = vEmail;
        accounts = new ArrayList<Account>();
    }

    
    public void displaySortedByIBAN(){

        ArrayList<Account> dupeAccounts = accounts;

        Collections.sort(dupeAccounts,
            new Comparator<Account>(){
                public int compare(Account a1, Account a2){
                    return a1.getIBAN().compareTo(a2.getIBAN());
                }
            });
        
        System.out.println();
        System.out.println(this.username + ", these are your bank accounts, sorted by IBAN: ");
        for(Account account : dupeAccounts)
            System.out.println(account.toString());
    }

    
    public void displaySortedByCurrency(){

        ArrayList<Account> dupeAccounts = accounts;

        Collections.sort(dupeAccounts,
            new Comparator<Account>(){
                public int compare(Account a1, Account a2){
                    return a1.getCurrency().compareTo(a2.getCurrency());
                }
            });
        
        System.out.println();
        System.out.println(this.username + ", these are your bank accounts, sorted by Currency: ");
        for(Account account : dupeAccounts)
            System.out.println(account.toString());
    }


    public void displaySortedBySum(){
        ArrayList<Account> dupeAccounts = accounts;

        Collections.sort(dupeAccounts,
            new Comparator<Account>(){
                public int compare(Account a1, Account a2){
                    
                    if(a1.getCurrency() == Currency.USD){   //first account currency is USD
                        if(a2.getCurrency() == Currency.USD)
                            return a1.getConvertedFromUSD().compareTo(a2.getConvertedFromUSD());
                        else if(a2.getCurrency() == Currency.RON)
                            return a1.getConvertedFromUSD().compareTo(a2.getConvertedFromRON());
                        else 
                           return a1.getConvertedFromUSD().compareTo(a2.getSum());                             
                    }
                    else if(a1.getCurrency() == Currency.RON){ //first account currency is RON
                        if(a2.getCurrency() == Currency.USD)
                            return a1.getConvertedFromRON().compareTo(a2.getConvertedFromUSD());
                        else if(a2.getCurrency() == Currency.RON)
                            return a1.getConvertedFromRON().compareTo(a2.getConvertedFromRON());
                        else
                            return a1.getConvertedFromRON().compareTo(a2.getSum());
                    }
                    else{   //first account currency is EUR
                        if(a2.getCurrency() == Currency.USD)
                            return a1.getSum().compareTo(a2.getConvertedFromUSD());
                        else if(a2.getCurrency() == Currency.RON)
                            return a1.getSum().compareTo(a2.getConvertedFromRON());
                        else
                            return a1.getSum().compareTo(a2.getSum());

                    }
                }
        });
        
        System.out.println();
        System.out.println(this.username + ", these are your bank accounts, sorted by sum: ");
        for(Account account : dupeAccounts)
            System.out.println(account.toString());
    }
    
    public Map<Currency, Double> currencyMap(){

        Map<Currency, Double> currencyMap = new HashMap<Currency, Double>();
        
        double usdSum = 0;
        double ronSum = 0;
        double eurSum = 0;

        for(Account account : accounts)
            if(account.getCurrency() == Currency.USD)
                usdSum += account.getConvertedFromUSD();
            else if(account.getCurrency() == Currency.EUR)
                eurSum += account.getSum();
            else 
                ronSum += account.getConvertedFromRON();

        currencyMap.put(Currency.EUR, eurSum);
        currencyMap.put(Currency.USD, usdSum);
        currencyMap.put(Currency.RON, ronSum);
            
        return currencyMap;

    }
    
}
