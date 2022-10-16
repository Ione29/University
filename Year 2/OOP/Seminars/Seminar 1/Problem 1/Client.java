import java.time.LocalDate;

class Client{
    private String name;
    private LocalDate bday;
    private String CNP;
    private Account accounts[];
    private int nrAccounts;

    public Client(String vName, LocalDate vBday, String vCNP){
        this.name = vName;
        this.bday = vBday;
        this.CNP = vCNP;
        Account accounts[] = new Account[10];
    }

    public void addAccount(Account a){
        accounts[nrAccounts++] = a;
    }

    public boolean removeAccount(String iban){
        for(int i = 0; i < nrAccounts; i++)
            if(accounts[i].getIBAN().equals(iban))
            {
                for(int j = i; j < nrAccounts - 1; j++)
                    accounts[j] = accounts[j + 1];

                nrAccounts--;
                return true;
            }
        
        return false;
    }
}