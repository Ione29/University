public interface Taxable {
    double computeVAT();
    double computeRoadTax();
    double computeCustomTax();
    double computeTotalTax();
}
