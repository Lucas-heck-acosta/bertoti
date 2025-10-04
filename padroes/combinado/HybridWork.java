public class HybridWork implements WorkMode {
    @Override
    public double calculateProductivity() {
        return 0.95;
    }

    @Override
    public String getModeName() {
        return "Hybrid";
    }
}

