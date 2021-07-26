package com.example.AirCraftSystem.controller;

import com.example.AirCraftSystem.model.AirCraft;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.PriorityQueue;

@RestController
public class AirCraftController {

    //PriorityQueue, a DS that keeps the natural ordering of the inserted elements by placing them in a min heap. THis can be sort based
    //on a comparator as well.
    PriorityQueue<AirCraft> priorityQueue=
            new PriorityQueue<AirCraft>(Comparator.comparingInt(AirCraft::hashCode));

    private boolean isOnline = false;

    //To see all crafts currently in queue
    @GetMapping(path = "/getAll")
    public ResponseEntity<String> createAirCraft(){
        StringBuilder stringBuilder = new StringBuilder();
        for(AirCraft airCraft1: priorityQueue){
            stringBuilder.append(airCraft1.toString());
            stringBuilder.append("\n");
            stringBuilder.append("----------------");
            stringBuilder.append("\n");
        }
        ResponseEntity<String> responseEntity = new ResponseEntity(stringBuilder.toString(), HttpStatus.ACCEPTED);
        return responseEntity;
    }

    //Boots system online
    @PutMapping(path = "/boot")
    public ResponseEntity<String> bootAirCraftQueue(@RequestParam String status){
        StringBuilder stringBuilder = new StringBuilder();
        ResponseEntity<String> responseEntity = null;
        if(!status.equals("on") && !status.equals("off")){
        stringBuilder.append("Not a valid operation");
        responseEntity = new ResponseEntity(stringBuilder,HttpStatus.BAD_REQUEST);
        }
        if(status.equals("on")){
            isOnline = true;
            stringBuilder.append("AirCraftQueue is online");
            responseEntity = new ResponseEntity(stringBuilder,HttpStatus.OK);
        }
        if(status.equals("off")){
            isOnline = false;
            stringBuilder.append("AirCraftQueue is offline");
            responseEntity = new ResponseEntity(stringBuilder,HttpStatus.OK);
        }
        return responseEntity;
    }


    //inserts into queue and prints all current crafts in the queue
    @PostMapping(path = "/create")
    public ResponseEntity<String> createAirCraft(@RequestBody AirCraft airCraft){
        ResponseEntity<String> responseEntity = null;
        StringBuilder stringBuilder = new StringBuilder();
        if(isOnline) {
            aqmRequestProcess(true, airCraft);
            for (AirCraft airCraft1 : priorityQueue) {
                stringBuilder.append(airCraft1.toString());
                stringBuilder.append("\n");
                stringBuilder.append("----------------");
                stringBuilder.append("\n");
            }
            responseEntity = new ResponseEntity(stringBuilder.toString(), HttpStatus.ACCEPTED);
        } else {
            stringBuilder.append("AirCraftQueue is offline");
            responseEntity = new ResponseEntity(stringBuilder,HttpStatus.BAD_REQUEST);
        }

        return responseEntity;

    }

    //Delete craft ontop of the queue and prints all current crafts in queue
    @DeleteMapping(path = "delete")
    public ResponseEntity<String> dequeAirCraft(){
        StringBuilder stringBuilder = new StringBuilder();
        ResponseEntity<String> responseEntity = null;
        aqmRequestProcess(false,null);
        if(isOnline) {
            for (AirCraft airCraft1 : priorityQueue) {
                stringBuilder.append(airCraft1.toString());
                stringBuilder.append("\n");
                stringBuilder.append("----------------");
                stringBuilder.append("\n");
            }
            responseEntity = new ResponseEntity(stringBuilder.toString(), HttpStatus.ACCEPTED);
        } else {
            stringBuilder.append("AirCraftQueue is offline");
            responseEntity = new ResponseEntity(stringBuilder,HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    private void aqmRequestProcess(boolean add, AirCraft airCraft){
        if(add){
            //inserts ontop of the priority queue, this will sort upon each insert to keep the natural order...one finding is if you
            //spam the request sometimes you can catch the queue in mid sort. Optimization needed here.
            priorityQueue.add(airCraft);
        } else {
            //removes the first element off of the priority queue
            priorityQueue.poll();
        }
    }
}
