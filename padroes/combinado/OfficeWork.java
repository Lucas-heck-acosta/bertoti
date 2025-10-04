public class OfficeWork implements WorkMode {
    @Override
    public double calculateProductivity() {
        return 1.0;
    }

    @Override
    public String getModeName() {
        return "Office";
    }
}

