import java.util.*;
public class Memento {
	private String state;
	 
    public Memento(String stateToSave)
    {
        state = stateToSave; 
    }
 
    public String getSavedState()
    {
        return state; 
    }
}
 
class Originator 
{
    private String state;

 
    public void set(String state) 
    { 
       System.out.println("Cambiando al estado: "+state);
       this.state = state; 
    }
 
    public Memento saveToMemento() 
    { 
        System.out.println("Grabando Memento.");
        return new Memento(state); 
    }
 
    public void restoreFromMemento(Memento m) 
    {
        state = m.getSavedState(); 
        System.out.println("Estado despues de restaurar desde el Memento: "+state);
    }
}   
 
class Caretaker {
   private ArrayList<Memento> savedStates = new ArrayList<Memento>();
 
   public void addMemento(Memento m) { savedStates.add(m); }
   public Memento getMemento(int index) { return savedStates.get(index); }
}   
 
class MementoExample {
   public static void main(String[] args) {
       Caretaker caretaker = new Caretaker();
 
       Originator originator = new Originator();
       originator.set("State1");
       originator.set("State2");
       caretaker.addMemento( originator.saveToMemento() );
       originator.set("State3");
       caretaker.addMemento( originator.saveToMemento() );
       originator.set("State4");
 
       originator.restoreFromMemento( caretaker.getMemento(1) );
   }
}
