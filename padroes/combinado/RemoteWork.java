public class RemoteWork implements WorkMode {
    @Override
    public double calculateProductivity() {
        return 0.9;
    }

    @Override
    public String getModeName() {
        return "Remote";
    }
}

