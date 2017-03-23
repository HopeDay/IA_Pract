/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica001;

import java.util.ArrayList;

/**
 *
 * @author Dayra
 */
public class Practica001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        State initial = new State();
        initial.oveja = State.Position.DERECHA;
        initial.repollo = State.Position.DERECHA;
        initial.lobo = State.Position.DERECHA;
        initial.granjero = State.Position.DERECHA;
        System.out.println("Estado inicial:"+ initial);
        ArrayList<Transition> next = initial.validTransitions();
        System.out.println("Transiciones" + next.size());
        
        for (Transition t: next){
            System.out.println("Acción:"+ t.action);
            System.out.println("Resultado:"+ t.doTransition());
        }
    }
    
}
