package com.example.AirCraftSystem.model;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

import static com.example.AirCraftSystem.constants.Constants.*;

public class AirCraft {

    private String type;
    private String size;
    //A way to generate Id.
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size.toLowerCase(Locale.ROOT);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.toLowerCase(Locale.ROOT);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCraft airCraft = (AirCraft) o;
        return Objects.equals(getType(), airCraft.getType()) && Objects.equals(getSize(), airCraft.getSize());
    }

    //Here we override the hashCode values to assign a value based on size and type. Passenger has priority over Cargo,
    //and large has priority over small. We'll use this hashCode in our PriorityQueue which will sort the queue based on type and size
    //upon each insert.
    @Override
    public int hashCode(){
        int x = 0;
        int y = 0;

        if(size.equals(small)){
            x = 1;
        }

        if(size.equals(large)){
            x = 0;
        }

        if(type.equals(passenger)){
            y =0;
        }

        if(type.equals(cargo)){
            y =2;
        }

        if(!size.toLowerCase(Locale.ROOT).equals(small) && !size.toLowerCase(Locale.ROOT).equals(large)){
            x=5;
        }
        if(!type.toLowerCase(Locale.ROOT).equals(passenger) && !type.toLowerCase(Locale.ROOT).equals(cargo)){
            y = 5;
        }

        System.out.println("HASHCODE CALLED");
        System.out.println(toString());

        return x+y;
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
