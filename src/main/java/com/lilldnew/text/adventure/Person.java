/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lilldnew.text.adventure;
import java.util.*;

/**
 *
 * @author Admin
 * 
 */

public class Person {
    String name;
    int health;
    int damage;
    public Person (){
        health=100;
    }
    public Person(String gname, boolean gisMale, boolean gisDating, int gage, int ghealth, int gdamage)
    {
        name=gname;
        health=ghealth;
        damage=gdamage;
    }

    /**
     *
     * @param gname given name
     * @param gisMale true for male, false for female
     
     * @param gage given age
     */
    public void update(String gname, boolean gisMale, boolean gisDating, int gage, int ghealth)
    {
        name=gname;    
        health=ghealth;
    }
    
  
    public int getHealth(){
        return health;
    }
    public void updateName(String gname){
        name=gname;
        
    }
    public String getName(){
        return name;
    }
    public void attack(Person enemy){
        Random random = new Random();
        int variability = random.nextInt(10) +5;
        enemy.reduceHealth(damage+variability);
    }
    public void reduceHealth(int amount){
        health-=amount;
        System.out.println(name + " health is now " + health);
        if (health<=0&&!name.equals("Your")){
            System.out.println(name + " is dead");
            
        }
    }
    public void rest(){
        damage+=5;
    }
    public void heal(){
        health+=10;
        System.out.println(name + " health is now " + health);
        
    }
    public boolean isDead(){
        if (health<=0){
            return true;
        }
        else{
            return false;
        }
    }
}
