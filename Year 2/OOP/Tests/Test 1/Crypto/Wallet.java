public class Wallet {
    private String publicKey;
    private String privateKey;

    public Wallet(String vPublicKey, String vPrivateKey){
        this.publicKey = vPublicKey;
        this.privateKey = vPrivateKey;
    }

    public String getPublicKey(){
        return this.publicKey;
    }

    public String getPrivateKkey(){
        return this.privateKey;
    }
}
