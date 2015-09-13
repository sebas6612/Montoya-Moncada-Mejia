/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import comun.EmptyStructureException;
import comun.Node;

/**
 *
 * @author s212e10
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStructureException("Estructura vacia");
        }
        return top.getItem();
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStructureException("Estructura vacia");
        }
        E aux = top.getItem();
        top = top.getNext();
        return aux;
    }

    @Override
    public void push(E target) {
        top = new Node<>(target, top);
    }
    
    public int size(){
        int cont = 0;
        Node<E> temporal = top;
        
        while(temporal != null){
            cont++;
            temporal = temporal.getNext();
        }
        return cont;
    }
}
