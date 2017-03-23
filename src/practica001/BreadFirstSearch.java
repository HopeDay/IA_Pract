/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica001;

import java.util.ArrayList;

/**
 *
 * @author Dayra
 */
public class BreadFirstSearch {
    public State initial_state;
    public boolean founded_final_state = false;
    
    public BreadFirstSearch (State initial_state){
        
    }
    
    public void doSearch(){
        int level = 1;
        System.out.println("Estado inicial: " + initial_state);
        ArrayList<State>current_states = new ArrayList<>();
        ArrayList<State>next_states = new ArrayList<>();
        ArrayList<State>visited_states = new ArrayList<>();
                
        current_states.add(initial_state);
        while (!founded_final_state){
            System.out.println("Generando estado de nivel: " + level);
            //generar estado soguiente y los validados
            for (State state: current_states){
                for (Transition t: state.validTransitions()){
                    State next = t.doTransition();
                    if (next.isValid()&&!visited_states.contains(next)){
                        System.out.println("-Acción: " + t.action + ", resultado: " + next);
                        next_states.add(next);
                    }
                }
            }
        }
                
    }
}
