public class SoftwareProduct {
    private String name;
    private String platform;
    private int minRAM;
    private String minCPU;

    public SoftwareProduct(String vName, String vPlatform, int vMinRAM, String vMinCPU){
        this.name = vName;
        this.platform = vPlatform;
        this.minRAM = vMinRAM;
        this.minCPU = vMinCPU;
    }

    public boolean checkCompatibility(Computer c){
        if(this.minRAM > c.getRAM())
            return false;
        
        if(this.minCPU.equals("i5") && c.getCPU().equals("i3"))
            return false;
        else if(this.minCPU.equals("i7") && (c.getCPU().equals("i3") || c.getCPU().equals("i5")))
            return false;
            
        return true;
    }
}
