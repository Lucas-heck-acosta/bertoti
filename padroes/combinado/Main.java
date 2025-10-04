public class Main {
    public static void main(String[] args) {
        System.out.println("=== COMBINED PATTERNS: Strategy + Observer + Composite ===\n");

        HRMonitor hrSystem = new HRMonitor("HR System");
        HRMonitor managementDashboard = new HRMonitor("Management Dashboard");

        Department company = new Department("TechCorp");
        Department itDepartment = new Department("IT Department");
        Department devTeam = new Department("Development Team");

        Employee alice = new Employee("Alice", "Senior Developer", new OfficeWork());
        Employee bob = new Employee("Bob", "Junior Developer", new RemoteWork());
        Employee carol = new Employee("Carol", "Tech Lead", new HybridWork());
        Employee dave = new Employee("Dave", "DevOps Engineer", new RemoteWork());

        devTeam.addComponent(alice);
        devTeam.addComponent(bob);
        devTeam.addComponent(carol);

        itDepartment.addComponent(devTeam);
        itDepartment.addComponent(dave);

        company.addComponent(itDepartment);

        company.addObserver(hrSystem);
        company.addObserver(managementDashboard);

        System.out.println("Initial company structure:");
        company.showDetails();

        System.out.println("\n--- Changing work modes (Strategy pattern in action) ---");

        System.out.println("\nBob switching from Remote to Hybrid work:");
        bob.setWorkMode(new HybridWork());

        System.out.println("\nAlice switching from Office to Remote work:");
        alice.setWorkMode(new RemoteWork());

        System.out.println("\n--- Updated company structure ---");
        company.showDetails();

        System.out.println("\n--- Adding new employee (Composite pattern) ---");
        Employee eve = new Employee("Eve", "Security Specialist", new OfficeWork());
        itDepartment.addComponent(eve);

        System.out.println("\n=== PATTERNS DEMONSTRATED ===");
        System.out.println("✓ Composite: Hierarchical company structure (Company > IT > DevTeam > Employees)");
        System.out.println("✓ Strategy: Different work modes affecting productivity (Office, Remote, Hybrid)");
        System.out.println("✓ Observer: HR systems automatically notified of productivity changes");
        System.out.println("✓ Integration: All patterns work seamlessly together");
    }
}

