public class Main {
    public static void main(String[] args) {        
    Computer pc1 = new Computer(4, "i3");
    Computer pc2 = new Computer(8, "i5");
    Computer pc3 = new Computer(16, "i5");
    Computer pc4 = new Computer(32, "i7");
    //Computer pc5 = new Computer(4, "i42");
    
    SoftwareProduct sp1 = new SoftwareProduct("muzica", "windows", 4, "i3");
    SoftwareProduct sp2 = new SoftwareProduct("jocuri", "linux", 16, "i5");
    SoftwareProduct sp3 = new SoftwareProduct("photoshop", "macOS", 8, "i3");
    SoftwareProduct sp4 = new SoftwareProduct("blender", "windows", 32, "i7");
}
}
