/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica001;

import java.util.ArrayList;
import practica001.Transition.Action;

/**
 *
 * @author Dayra
 */
public class State {
    public enum Position {DERECHA, IZQUIERDA}
    
    public Position oveja;
    public Position repollo;
    public Position lobo;
    public Position granjero;
    
    public boolean isValid(){
        if ((oveja == Position.DERECHA)&& 
                (repollo == Position.DERECHA)&&
                (granjero == Position.IZQUIERDA))
            return false;
        if ((oveja == Position.DERECHA)&&
                (lobo == Position.DERECHA)&&
                (granjero == Position.IZQUIERDA))
            return false;
            //terminar toda la lista de estados invalidos
        return true;
    }
    public boolean isFinal(){
        if ((oveja == Position.IZQUIERDA)&&
                (repollo == Position.IZQUIERDA)&&
                (lobo == Position.IZQUIERDA)&&
                (granjero == Position.IZQUIERDA))
            return true;
        return false;
        
    }
    
    public ArrayList<Transition> validTransitions(){
        ArrayList<Transition> result = new 
            ArrayList<Transition>();
        //Mover al granjero siempre es posible
        result.add(new Transition(this,Action.MOVER_GRANJERO));
        //Mover a la oveja solo es posible con el granjero
        if (oveja == granjero){
            result.add(new Transition(this,Action.MOVER_OVEJA));
        }
        //Mover a los demas objetos queda en la comodidad 
        //de su hogar
        return result;
    }
    public static void main(String[] args){
        State test = new State();
        test.granjero = Position.DERECHA;
        System.out.print(test);
   }
    @Override
    public String toString(){
        return "Posición oveja: " + oveja + "," +
                "Posición repollo: "+ repollo + "," +
                "Posición lobo: " + lobo + "," +
                "Posición granjero: "+ granjero;
                }
    
}
