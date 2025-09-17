package comision;

import comision.Models.Container;
import comision.Models.Ship;

public class Main extends AbstrctPort {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while (true) {
        	System.out.println("_________________________________________________");
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
        	System.out.println("_________________________________________________");

            System.out.print("Choose an option: ");

            switch (sc.nextLine()) {
                case "1" -> storeContainer();
                case "2" -> viewContainers();
                case "3" -> registerShip();
                case "4" -> viewShips();
                case "5" -> loadNextShip();
                case "0" -> { 
                	System.out.println("_________________________________________________");

                    System.out.println("Exiting program."); 
                    return; 
                }
                
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    @Override
    public void storeContainer() {
    	System.out.println("_________________________________________________");

        System.out.print("Enter container ID: ");
        String id = sc.nextLine().trim();
        System.out.println("");
        System.out.print("Enter description: ");
        String desc = sc.nextLine().trim();
        System.out.println("");
        System.out.print("Enter weight (kg): ");
        int weight;
        try {
            weight = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
        	System.out.println("_________________________________________________");
            System.out.println("Invalid weight input.");
            return;
        }
        Container c = new Container(id, desc, weight);
        containerStack.push(c);
    	System.out.println("_________________________________________________");
        System.out.println("Stored: " + c);
    }

    @Override
    public void viewContainers() {
        if (containerStack.isEmpty()) {
        	System.out.println("_________________________________________________");
            System.out.println("No containers in the port.");
            return;
        }
    	System.out.println("_________________________________________________");
        System.out.println("TOP →");
        containerStack.forEach(System.out::println);
        System.out.println("← BOTTOM");
    	System.out.println("_________________________________________________");

    }

    @Override
    public void registerShip() {
    	System.out.println("_________________________________________________");

        System.out.print("Enter ship name: ");
        String name = sc.nextLine().trim();
        System.out.println("");
        System.out.print("Enter captain name: ");
        String captain = sc.nextLine().trim();
        System.out.println("");
        Ship s = new Ship(name, captain);
        shipQueue.offer(s);
    	System.out.println("_________________________________________________");
        System.out.println("Registered: " + s);
    }

    @Override
    public void viewShips() {
        if (shipQueue.isEmpty()) {
        	System.out.println("_________________________________________________");
            System.out.println("No ships waiting.");
            return;
            
        }
        
    	System.out.println("_________________________________________________");

        System.out.println("FRONT →");
        shipQueue.forEach(System.out::println);
        System.out.println("← REAR");
    	System.out.println("_________________________________________________");

    }

    @Override
    public void loadNextShip() {
        if (containerStack.isEmpty()) {
        	System.out.println("_________________________________________________");

            System.out.println("No containers available to load.");
            return;
        }
        if (shipQueue.isEmpty()) {
        	System.out.println("_________________________________________________");

            System.out.println("No ships waiting to be loaded.");
            return;
        }
        Container c = containerStack.pop();
        Ship s = shipQueue.poll();
    	System.out.println("_________________________________________________");

        System.out.println("Loaded: " + c + " → " + s);
        System.out.println("");
        System.out.println("Remaining containers: " + containerStack.size());
        System.out.println("");
        System.out.println("Remaining ships waiting: " + shipQueue.size());
    }
}

