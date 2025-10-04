import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name + " - Total Productivity: " +
                         String.format("%.1f%%", getTotalProductivity() * 100));
        for (OrganizationComponent component : components) {
            System.out.print("  ");
            component.showDetails();
        }
    }

    @Override
    public double getTotalProductivity() {
        if (components.isEmpty()) return 0.0;

        double total = 0.0;
        for (OrganizationComponent component : components) {
            total += component.getTotalProductivity();
        }
        return total / components.size();
    }

    @Override
    public void addComponent(OrganizationComponent component) {
        components.add(component);
        for (Observer observer : observers) {
            component.addObserver(observer);
        }
        notifyObservers();
    }

    @Override
    public void removeComponent(OrganizationComponent component) {
        components.remove(component);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        super.addObserver(observer);
        for (OrganizationComponent component : components) {
            component.addObserver(observer);
        }
    }

    public List<OrganizationComponent> getComponents() {
        return new ArrayList<>(components);
    }
}
