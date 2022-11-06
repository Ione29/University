public class Computer {
    private int ram;
    private String cpu;
    private SoftwareProduct installedProducts[];
    private int nrInstalledProducts;

    public Computer(int vRam, String vCpu){
        if(vRam != 4 && vRam != 8 && vRam != 16 && vRam != 32)
            throw new IllegalArgumentException("Bad RAM Ammount!");
        
        if(!(vCpu.equals("i3")) && !(vCpu.equals("i5")) || !(vCpu.equals("i7")))
            throw new IllegalArgumentException("CPU not Compatible");
        this.ram = vRam;
        this.cpu = vCpu;
        SoftwareProduct installedProducts[] = new SoftwareProduct[100];
        nrInstalledProducts = 0;
    }

    public int getRAM(){
        return this.ram;
    }

    public String getCPU(){
        return this.cpu;
    }

    public boolean addProduct(SoftwareProduct sp){
        if(sp.checkCompatibility(this)){
            installedProducts[nrInstalledProducts++] = sp;
            return true;
        }

        return false;
    }

}
