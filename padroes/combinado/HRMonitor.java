public class HRMonitor implements Observer {
    private String name;

    public HRMonitor(String name) {
        this.name = name;
    }

    @Override
    public void update(String componentName, double productivity) {
        System.out.println("[" + name + "] Alert: " + componentName +
                         " productivity changed to " + String.format("%.1f%%", productivity * 100));

        if (productivity < 0.8) {
            System.out.println("  -> Action Required: Low productivity detected!");
        } else if (productivity > 0.95) {
            System.out.println("  -> Recognition: Excellent productivity!");
        }
    }
}

