public class Employee extends OrganizationComponent {
    private String position;
    private WorkMode workMode;
    public Employee(String name, String position, WorkMode workMode) {
        super(name);
        this.position = position;
        this.workMode = workMode;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + " (" + position + ") - Mode: " +
                         workMode.getModeName() + " - Productivity: " +
                         String.format("%.1f%%", getTotalProductivity() * 100));
    }

    @Override
    public double getTotalProductivity() {
        return workMode.calculateProductivity();
    }

    @Override
    public void addComponent(OrganizationComponent component) {
        throw new UnsupportedOperationException("Employee cannot have subordinates");
    }

    @Override
    public void removeComponent(OrganizationComponent component) {
        throw new UnsupportedOperationException("Employee cannot have subordinates");
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
        notifyObservers();
    }

    public String getPosition() {
        return position;
    }
}

