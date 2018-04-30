/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.ws;

/**
 *
 * @author ewa
 */
public class Flight {
    private int id;   
   private String cityFrom, cityTo, time, day;    

    Flight(String string) {
        this.cityFrom = string;
    }
  
   public int getId() { 
      return id; 
   } 
   public String getCityFrom() { 
      return cityFrom; 
   } 
   public String getCityTo() { 
      return cityTo; 
   } 
   public String getDay() { 
      return day; 
   } 
   public String getTime() { 
      return time; 
   } 
   public void setID(int id) { 
      this.id = id; 
   } 
   public void setCityFrom(String cityFrom) { 
      this.cityFrom = cityFrom; 
   } 
   public void setCityTo(String cityTo) { 
      this.cityTo = cityTo; 
   } 
   public void setDay(String day) { 
      this.day = day; 
   } 
   public void setTime(String Time) { 
      this.time = time; 
   } 
   
     public Flight(int id, String cityFrom,String cityTo, String day, String time){
        this.id = id;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.day = day;
        this.time = time;
    }
}
