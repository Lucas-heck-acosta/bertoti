import java.util.ArrayList;
import java.util.List;

public abstract class OrganizationComponent implements Subject {
    protected String name;
    protected List<Observer> observers = new ArrayList<>();

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void showDetails();
    public abstract double getTotalProductivity();
    public abstract void addComponent(OrganizationComponent component);
    public abstract void removeComponent(OrganizationComponent component);

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, getTotalProductivity());
        }
    }

    public String getName() {
        return name;
    }
}
