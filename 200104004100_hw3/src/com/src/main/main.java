package com.src.main;

import java.util.ArrayList;
import java.util.LinkedList;
///// IMPORTANT: SINCE THERE IS NO LOOP INSIDE THIS CLASS, ALL OF THE ASSIGNMENTS ARE IN THE LINEAR TIME
public class main {
    static void driver() throws Exception {
        System.out.println("*****************TESTING THE ARRAYLIST STRUCTURE*****************");

        House h= new House(2,4,5,6,"Red","Burak");
        Market market = new Market(2,0,3,4,5,"Hasan");
        Office office= new Office(1,9,3,"Game Store","ibrahim");
        Playground play= new Playground(1,2,3);
        ArrayList<Building> array =new ArrayList<Building>();
        array.add(h);
        array.add(market);
        array.add(office);
        array.add(play);

        StreetArrayList streetArrayList = new StreetArrayList(20,array,4);

        try {
            // Testing the street size exception with array
            streetArrayList = new StreetArrayList(20,array,4);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ADDING HOUSE INTO ARRAYLIST");
            streetArrayList.addHouse(4,1,7,11,"Blue","Yusuf");
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("ADDING OFFICE INTO ARRAYLIST");
            streetArrayList.addOffice(3,4,11,"Store","Yerda");
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("DELETING OFFICE INTO ARRAYLIST");
            streetArrayList.deleteOffice(11);
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ADDING MARKET INTO ARRAYLIST");
            streetArrayList.addMarket(3,1,15,9,12,"Erkan");
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("DELETING MARKET INTO ARRAYLIST");
            streetArrayList.deleteMarket(15);
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ADDING PLAYGROUND INTO ARRAYLIST");
            streetArrayList.addPlayground(1,4,19);
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("DELETING PLAYGROUND INTO ARRAYLIST");
            streetArrayList.deletePlayground(19);
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("DELETING HOUSE INTO ARRAYLIST");
            streetArrayList.deleteHouse(4);
            streetArrayList.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("FINDING EMPTY AREAS INTO ARRAYLIST");
        streetArrayList.findEmptyAreas();
        System.out.println("FINDING NUMBER OF REMANING CELLS INTO ARRAYLIST");
        streetArrayList.calculateTotalNumberofRemainingLength();

        streetArrayList.calculateNumberandRatioofPlaygrounds();
        streetArrayList.calculatetotalNumberofNonPlaygrounds();

        House h1= new House(2,8,11,6,"Red","Akgul");
        Market market1 = new Market(2,0,3,4,5,"Zergeroglu");
        Office office1= new Office(4,3,3,"Store","Aptoula");
        Playground play1= new Playground(3,12,3);

        ArrayList<Building> array1 =new ArrayList<Building>();
        LinkedList<Building> array2= new LinkedList<Building>();

        array2.add(h1);
        array2.add(market1);
        array2.add(office1);
        array2.add(play1);

        array1.add(h1);
        array1.add(market1);
        array1.add(office1);
        array1.add(play1);

        StreetArrayList list1 = new StreetArrayList(20,array1,4);
        System.out.println("*******DRAWING THE SKYLINE FOR ARRAYLIST***********");
        list1.drawSkyline(streetArrayList);

        StreetLinkedList list2 = new StreetLinkedList(20,array2,4);


        System.out.println("*******DRAWING THE SKYLINE FOR LINKEDLIST***********");


        list2.showBuildings();
        try{
            System.out.println("ADDING OFFICE INTO LINKEDLIST");
            list2.addOffice(3,4,11,"Store","Yerda");
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("DELETING OFFICE INTO LINKEDLIST");
            list2.deleteOffice(11);
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ADDING MARKET INTO LINKEDLIST");
            list2.addMarket(3,1,15,9,12,"Erkan");
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("DELETING MARKET INTO LINKEDLIST");
            list2.deleteMarket(15);
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ADDING PLAYGROUND INTO LINKEDLIST");
            list2.addPlayground(1,4,19);
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("DELETING PLAYGROUND INTO LINKEDLIST");
            list2.deletePlayground(19);
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("DELETING HOUSE INTO LINKEDLIST");
            list2.deleteHouse(4);
            list2.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("FINDING EMPTY AREAS INTO LINKEDLIST");
        list2.findEmptyAreas();
        System.out.println("FINDING NUMBER OF REMANING CELLS INTO LINKEDLIST");
        list2.calculateTotalNumberofRemainingLength();

        list2.calculateNumberandRatioofPlaygrounds();
        list2.calculatetotalNumberofNonPlaygrounds();


        list2.drawSkyline(list1);






        System.out.println("***************TESTING LDLINKEDLIST METHODS****************");
        StreetLDLinkedList list= new StreetLDLinkedList();
        System.out.println("Adding house into linked list");
        list.add(h1);
        System.out.println("After adding house into linked list");
        list.printList();
        System.out.println("Adding market into linked list");
        list.add(market1);
        System.out.println("After adding market into linked list");
        list.printList();
        System.out.println("Adding office into the node with index 1 into linked list");
        list.add(1,office1);
        list.printList();
        System.out.println("Linked list: ");
        list.printList();
        System.out.println("Testing the get method by index 0: ");
        System.out.println(list.get(0));
        System.out.println("Testing the size method : ");
        System.out.println(list.size());
        System.out.println("Testing the indexOf method : ");
        System.out.println(list.indexOf(market1));
        System.out.println("Testing the getFirst method: ");
        System.out.println(list.getFirst());
        System.out.println("Testing the getLast method: ");
        System.out.println(list.getLast());
        System.out.println("Testing the peek method");
        System.out.println(list.peek());
        System.out.println("Testing the peekFirst method");
        System.out.println(list.peekFirst());
        System.out.println("Testing the peekLast method");
        System.out.println(list.peekLast());
        System.out.println("Testing the clear method");
        list.clear();
        System.out.println("After clear: " + list.toString());
        System.out.println("Testing the addAll method");
        list.addAll(array1);
        System.out.println("After addAll: " + list.toString());
        System.out.println("Testing remove function");
        System.out.println("Before remove function");
        list.printList();
        list.remove(h1);
        System.out.println("After remove function");
        list.printList();

     }
    public static void main(String[] args) throws Exception {
        driver();
    }
}
