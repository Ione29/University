public interface FormOperations {
    void move(int x, int y);
    void shrink(double ratio);
    void enlarge(double ratio);
    void changeInnerColor(String color);
    void changeFormColor(String color);
}
