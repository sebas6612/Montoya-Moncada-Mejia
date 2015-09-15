/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import comun.EmptyStructureException;

/**
 *
 * @author s212e10
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{

    private E[] data;
    private int size;
    
    public ArrayStack(){
        data = (E[])(new Object[1]);
        size = 0; 
    }
        
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
    }
    
    protected void stretch(){
        E[] newData = (E[]) (new Object [2 * data.length]);
        
        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    
    
    @Override
    public E peek() throws EmptyStructureException{
        if(isEmpty()){
            throw new EmptyStructureException("Estructura vacia");
        }          
        return data[size - 1];
    }

    @Override
    public E pop() throws EmptyStructureException{
        if(isEmpty()){
            throw new EmptyStructureException("Estructura vacia");
        }
        --size;
        return data[size];
    }

    @Override
    public void push(E target) {
        if(isFull()){
            stretch();
        }
        data[size] = target;
        size ++;
    }
    
    public void fix(){
        E[] newData = (E[]) (new Object [size]);
        
        if(!isFull() && size < data.length){
            for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
        }
        
    }
    
}
