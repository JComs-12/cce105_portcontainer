package comision;

import java.util.ArrayDeque;
import java.util.Scanner;

public abstract class AbstrctPort {
	
    protected ArrayDeque<Models.Container> containerStack = new ArrayDeque<>();
    
    protected ArrayDeque<Models.Ship> shipQueue = new ArrayDeque<>();
    
    protected Scanner sc = new Scanner(System.in);

    public abstract void storeContainer();
    
    public abstract void viewContainers();
    
    public abstract void registerShip();
    
    public abstract void viewShips();
    
    public abstract void loadNextShip();
    
    
}
