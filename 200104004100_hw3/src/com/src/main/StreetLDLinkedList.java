package com.src.main;

import com.src.main.Building;

import java.util.*;
// TOTAL RUNNING TIME: Q(n^2)

public class StreetLDLinkedList extends AbstractList implements List{
    Node head; // head of list Q(1)
    private int size; // Q(1)
    LinkedList<Node> newList; // Q(1)
    private LinkedList<Building> buildingArray;// Q(1)
    private LinkedList<Integer> positionList;// Q(1)

    /**
     * default constructor
     */
    StreetLDLinkedList(){
        newList = new LinkedList<Node>();// Q(1)
    }
    /**
     *
     * @param element is the data of the given element
     * @returns the node with given element
     */
    static Node GetNode(Object element) {
        return new Node(element);// Q(1)
    }
    /**
     * Overridden add method uses lazy deletion strategy
     * @param o element will be added
     * @return true if add operation will be successful
     */
    @Override
    // Q(n^2)
    public boolean add(Object o) {
        LinkedList<Object> newList=new LinkedList<Object>();// Q(1)
        newList.add(0);// Q(1)
        if(newList.peek() != null){// Q(1)
            int size= newList.size();// Q(1)
            for (int i=0;i<size;i++){  // Q(n^2)
                if(newList.get(i) == o){
                    Node deletedNode = (Node) newList.get(i);
                    deletedNode.next=null;
                    Node last= head;
                    while (last.next != null) { // Q(n)
                        last = last.next;
                    }
                    last.next= deletedNode;
                    return true;
                }
            }
        }
        if(head == null){ // Q(1)
            Node node= new Node(o);// Q(1)
            head= node;// Q(1)
            node.next= null;// Q(1)
        }
        else {// Q(n)
            Node new_node = new Node((Building) o);// Q(1)
            new_node.next = null;// Q(1)
            Node last = head;// Q(1)
            while (last.next != null) {// Q(n)
                last = last.next;// Q(1)
            }
            last.next = new_node;// Q(1)
            return true;// Q(1)
        }
        return false;// Q(1)
    }

    /**
     * Overridden add method uses lazy deletion strategy with index
     * @param index of the element to be added
     * @param o element to be added
     */
    @Override
    public void add(int index, Object o) {// Q(1)
        if (index<1){// Q(1)
            return;// Q(1)
        }
        if(newList.peek() != null){// Q(1)
            int size= newList.size();// Q(1)
            for (int i=0;i<size;i++){// Q(n^2)
                if(newList.get(i) == o){// Q(1)
                    Node deletedNode = (Node) newList.get(i);// Q(1)
                    deletedNode.next=null;// Q(1)
                    Node last= head;// Q(1)
                    int k=1;// Q(1)
                    while (last.next != null && k!= index) { // Q(n)
                        last = last.next;// Q(1)
                        k++;// Q(1)
                    }
                    last.next= deletedNode;// Q(1)
                }
            }
        }
        if(head == null){// Q(1)
            Node node= new Node(o);// Q(1)
            head= node;// Q(1)
            node.next= null;// Q(1)
        }
        else {
            Node new_node = new Node((Building) o);// Q(1)
            Node last = head;// Q(1)
            int k=1;// Q(1)
            while (last.next != null && k!=index) {// Q(n)
                last = last.next;// Q(1)
                k++;// Q(1)
            }
            new_node.next= last.next;// Q(1)
            last.next = new_node;// Q(1)
        }
    }

    /**
     * returns the index of given element
     * @param o given element
     * @return index of the given element
     */
    @Override
    // Q(n)
    public int indexOf(Object o) {
        int index = 0;// Q(1)
        Node current = head;// Q(1)
        while (current != null) {// Q(n)
            if (current.data.equals(o)) {// Q(1)
                return index;// Q(1)
            }
            index++;// Q(1)
            current = current.next;// Q(1)
        }
        return -1;// Q(1)
    }
    public Object getFirst(){
        return head.data;
    }
    /**
     *
     * @return the last element of the LDlinked list
     */
    public Object getLast(){
        Node current = head;// Q(1)
        while(current.next !=null){// Q(n)
            current= current.next;// Q(1)
        }
        return current.data;// Q(1)
    }

    /**
     *
     * @return the head of the linked list
     */
    public Node peek(){// Q(1)
        return head;// Q(1)
    }

    /**
     *
     * @return the data of the first node which is head
     */
    public Node peekFirst(){// Q(1)
       if (head == null)// Q(1)
           return null;// Q(1)
       else
           return head;// Q(1)
    }/**
     *
     * @return the data of the last node
     */
    // Q(n)
    public Node peekLast(){
        if (head == null)// Q(1)
            return null;// Q(1)
        else{
            Node current = head;// Q(1)
            while (current.next != null){// Q(n)
                current= current.next;// Q(1)
            }
            return current;// Q(1)
        }
    }

    /**
     * Overridden get method
     * @param index index of the given element
     * @return the object with given index
     */
    @Override
    // Q(n)
    public Object get(int index) {
        Node current = head;// Q(1)
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)// Q(n)
        {
            if (count == index)// Q(1)
                return current.data;// Q(1)
            count++;// Q(1)
            current = current.next;// Q(1)
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);// Q(1)
        return false;// Q(1)
    }

    /**
     *
     * @return the size of the linked list
     */
    @Override
    // Q(n)
    public int size() {
        Node temp=head;// Q(1)
        int count = 0;// Q(1)
        while(temp!=null)// Q(n)
        {
            temp=temp.next;// Q(1)
            count++;// Q(1)
        }
        return count;// Q(1)
    }

    @Override
    // Q(1)
    public void clear() {
        head=null;
    }

    /**
     *
     */
    // Q(n)
    public void printList()
    { // Q(1)
        Node currNode = head;
        // Q(1)
        // Traverse through the LinkedList
        while (currNode != null) { // Q(n)
            // Print the data at current node
            System.out.print(currNode.data + "\n");// Q(1)

            // Go to next node
            currNode = currNode.next;// Q(1)
        }
    }

    /**
     *
     * @param c collection to be added into linked list
     * @return boolean value
     */
    @Override
    public boolean addAll( Collection c) {
       Object [] obj; // Q(1)
       obj = c.toArray();// Q(1)
       Node current = head;// Q(1)
       if(current == null){// Q(1)
           Node node= new Node(obj[0]);// Q(1)
           head =node;// Q(1)
           current = head;// Q(1)
           for (int i=1;i<c.size();i++){ // Q(n)
               Node newNode= new Node(obj[i]);// Q(1)
               newNode.next=null;// Q(1)
               current.next = newNode;// Q(1)
           }
       }
       else{
           while( current.next != null){ // Q(n)
               current= current.next;// Q(1)
           }
           for (int i=0;i<c.size();i++){// Q(n)
               Node newNode= new Node(obj[i]);// Q(1)
               newNode.next=null;// Q(1)
               current.next= newNode;// Q(1)
           }
       }
       return true;// Q(1)
    }

    /**
     *
     * @param element element to be removed
     * @return boolean value
     */
    @Override
    public boolean remove(Object element){

        // Store head node
        Node currNode = head, prev = null;// Q(1)

        if (currNode != null && currNode.data == element) {// Q(1)
            head = currNode.next; // Changed head// Q(1)
            // Display the message// Q(1)
            System.out.println(element + " found and deleted");// Q(1)
            Node newnode= new Node(element);// Q(1)
            newList.add(newnode);// Q(1)
            return true;// Q(1)
        }

        while (currNode != null && currNode.data != element) {// Q(1)
            // If currNode does not hold key
            // continue to next node
            prev = currNode;// Q(1)
            currNode = currNode.next;// Q(1)
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {// Q(1)
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;// Q(1)

            // Display the message
            System.out.println(element + " found and deleted");// Q(1)
            newList.add((Node) element);// Q(1)
            return true;// Q(1)
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {// Q(1)
            // Display the message
            System.out.println(element + " not found");// Q(1)
            return false;// Q(1)
        }
        return true;// Q(1)
    }

    /**
     * node class
     */
    static class Node {// Q(1)
        Building data;
        Node next;// Q(1)
        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(Object d) { data = (Building) d; }// Q(1)

        @Override
        public boolean equals(Object o) {// Q(1)
            if (this == o) return true;// Q(1)
            if (!(o instanceof Node)) return false;// Q(1)
            Node node = (Node) o;// Q(1)
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);// Q(1)
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);// Q(1)
        }
    }
    private int greater(int a, int b)
    {
        if (a > b) return a;
        return b;
    }
    /**
     *
     * @param lowList list contains start position of the buildings
     * @param highList list contains end position of the buildings
     * @return returns an integer list contains resulting buildings
     */
    // Q(n^2)
    private List<Integer[]> mergetheSkylines(List<Integer[]> lowList, List<Integer[]> highList)
    {
        int h1 = 0, h2 = 0;// Q(1)
        int newIndex = 0;// Q(1)
        List<Integer[]> mergedSkyline = new ArrayList<Integer[]>();;

        for (;;)
        {
            if (lowList.size()==0 || highList.size()==0)
            {// Q(1)
                break;// Q(1)
            }

            // first key points from both the skylines
            Integer [] start = lowList.get(0);// Q(1)
            Integer [] end = highList.get(0);// Q(1)

            // 0: 'x' co-ordinate, 1: height
            Integer [] mergedLine = new Integer[2];// Q(1)

            // comparing 'x' co-ordinates of current key points of skyline-1 and skyline-2
            if (start[0] < end[0]) // key point from skyline-1 is chosen
            {
                mergedLine[0] = start[0];// Q(1)
                mergedLine[1] = start[1];// Q(1)

               /*
               If the 'y' co-ordinate for a key point from Skyline-1 is less than the last seen height of Skyline-2, the merged key point's 'y' co-ordinate must be updated to the last seen height of Skyline-2.
                */
                if (start[1] < h2)// Q(1)
                {
                    mergedLine[1] = h2;// Q(1)
                }

                h1 = start[1];// Q(1)

                // move to next key point for this skyline
                lowList.remove(0);// Q(1)
            }
            else if (end[0] < start[0])// Q(1)
            {
                mergedLine[0] = end[0];// Q(1)
                mergedLine[1] = end[1];// Q(1)

                if (end[1] < h1)// Q(1)
                {
                    mergedLine[1] = h1;// Q(1)
                }

                // update the last seen height of skyline-2
                // note that last seen height of skyline-
                h2 = end[1];// Q(1)

                highList.remove(0);// Q(1)
            }

            /*
            If the 'x' coordinates of key points in both skylines are the same, then choose key point with the greater 'y' value to advance key points for both and thus update the last seen height for both.
             */
            else
            {
                mergedLine[0] = end[0];// Q(1)
                mergedLine[1] = greater(start[1], end[1]);// Q(1)

                h1 = start[1];// Q(1)
                h2 = end[1];// Q(1)

                lowList.remove(0);// Q(1)
                highList.remove(0);// Q(1)
            }

            mergedSkyline.add(mergedLine);// Q(1)
        }

        if (lowList.size()==0)// Q(1)
        {
            while (highList.size()!=0)// Q(1)
            {
                mergedSkyline.add(highList.remove(0));// Q(1)
            }
        }
        else
        {
            while (lowList.size()!=0)// Q(1)
            {
                mergedSkyline.add(lowList.remove(0));// Q(1)
            }
        }

        //Remove duplicate key points from the merged skyline

        for (int k = 0; k < mergedSkyline.size(); k++) {// Q(n^2)
            boolean found = true;
            int i = k + 1;
            while ((i < mergedSkyline.size()) && found) {// Q(n)
                if (mergedSkyline.get(k)[1] == mergedSkyline.get(i)[1]) {
                    found = true;
                    mergedSkyline.remove(i);
                } else {
                    found = false;
                }
            }
            k += 1;
        }
        return mergedSkyline;// Q(1)
    }

    /**
     *
     * @param low is the parameter indicates start point of the skyline
     * @param high is the parameter indicates end point of the skyline
     * @param buildings is the array that holds the resulting buildings
     * @return
     */
    // Q(2^n)
    private List<Integer[]> getTheSkyline(Integer low, Integer high, Integer[][]buildings)
    {
        List<Integer[]> skyLineList = new ArrayList<Integer[]>();// Q(1)
        Integer len_buildings= buildings.length;// Q(1)
        Integer[][] buildings_1= new Integer[size][];// Q(1)
        for(int i=0;i<size;i++){// Q(n)
            buildings_1[i]= new Integer[3];// Q(1)
        }
        Integer len_buildings1= buildings_1.length;
        for (int i=0;i<buildingArray.size();i++) {// Q(n)
            buildings_1[i][0]= buildingArray.get(i).getPosition();// Q(1)
            buildings_1[i][1]= buildingArray.get(i).getPosition()+buildingArray.get(i).getLength();// Q(1)
            buildings_1[i][2]= buildingArray.get(i).getHeight();// Q(1)
        }
        Integer[][] result= new Integer[len_buildings+len_buildings1][];// Q(1)
        for(int i=0;i<len_buildings+len_buildings1;i++){// Q(n)
            result[i]= new Integer[3];// Q(1)
        }


        System.arraycopy(buildings_1, 0, result, 0, len_buildings1);// Q(1)
        System.arraycopy(buildings, 0, result, len_buildings1, len_buildings);// Q(1)

        buildings= new Integer[len_buildings+len_buildings1][];// Q(1)
        for(int i=0;i<len_buildings+len_buildings1;i++){// Q(n)
            buildings[i]= new Integer[3];
        }

        System.arraycopy(result,0,buildings,0,len_buildings1+len_buildings);// Q(1)


        // invalid case
        if (low > high)// Q(1)
        {
            return skyLineList;// Q(1)
        }
        // base case: if there is only one building, only two key points define the skyline for it
        else if (low == high)
        {
            Integer x1 = buildings[low][0];// Q(1)
            Integer x2 = buildings[low][1];// Q(1)
            Integer h  = buildings[low][2];// Q(1)

            Integer[] element1 = {x1, h}; // first key point // Q(1)
            Integer[] element2 = {x2, 0}; // second key point // Q(1)

            skyLineList.add(element1);// Q(1)
            skyLineList.add(element2);// Q(1)

            return skyLineList;// Q(1)
        }
        // general case
        else
        {
            Integer mid = (low + high) / 2;// Q(1)

            // get the skyline for lower half
            List<Integer[]> skylineListLower = getTheSkyline(low, mid, buildings);// Q(logn)

            // get the skyline for upper half
            List<Integer[]> skylineListHigher = getTheSkyline(mid+1, high, buildings);// Q(nlogn)

            // merge skylines for these two halves
            return mergetheSkylines(skylineListLower, skylineListHigher);// Q(1)
        }
    }

    public List<Integer[]> getTheSkyline(Integer[][] buildings)
    {
        return getTheSkyline(0, buildings.length-1, buildings);// Q(logn)
    }
    static int mid=0;

    /**
     * draws the skyline into the screen
     * @param streetArrayList includes the second street's buildings
     */

    public void drawSkyline(StreetArrayList streetArrayList){
        ArrayList<Building> buildingArray_new_street= streetArrayList.getBuildingArray();
        Integer[][] buildings_1= new Integer[size][];
        // Q(n)
        for(int i=0;i<size;i++){
            buildings_1[i]= new Integer[3];
        }
        // Q(n)
        for (int i=0;i<buildingArray_new_street.size();i++){
            buildings_1[i][0]= buildingArray_new_street.get(i).getPosition();
            buildings_1[i][1]= buildingArray_new_street.get(i).getPosition()+buildingArray_new_street.get(i).getLength();
            buildings_1[i][2]= buildingArray_new_street.get(i).getHeight();
        }

        List<Integer[]> skyLine = getTheSkyline(buildings_1);
        // Q(1)
        int maxXcoordinate=skyLine.get(0)[0];
        int number_of_coloumns=0;
        // Q(n)
        for (int i = 0;  i < skyLine.size(); i++)
        {   if (skyLine.get(i)[0]>maxXcoordinate){
            maxXcoordinate= skyLine.get(i)[0];
        }
            number_of_coloumns= skyLine.get(i)[0];
        }

        /* we are combining the building arrays in a single array */
        // Q(n)
        for (int i=0;i<buildingArray.size();i++){
            buildingArray_new_street.add(buildingArray.get(i));
        }

        int maxHeight= skyLine.get(0)[1];
        // Q(n)
        for (int i=0;i<skyLine.size();i++){
            if(skyLine.get(i)[1]>maxHeight){
                maxHeight= skyLine.get(i)[1];
            }
        }

        Integer [][] silhoutteArray= new Integer[maxHeight][]; // Q(1)
        // Q(n)
        for(int i=0;i<maxHeight;i++){
            silhoutteArray[i]= new Integer[number_of_coloumns+1];
        }
        // Q(n^2)
        for (int i=0;i<maxHeight;i++){
            for(int j=0;j<number_of_coloumns+1;j++){
                silhoutteArray[i][j]=0;
            }
        }
        int flag1=0;// Q(1)
        // filling the array
        int flag=0;// Q(1)
        // Q(n^2)
        for (int i=0;i<skyLine.size();i++){
            if(i < skyLine.size()-1 && flag==0){
                Integer firstheight= skyLine.get(i)[1];
                Integer nextHeight= skyLine.get(i+1)[1];
                Integer firstPosition= skyLine.get(i)[0];
                Integer secondPosition= skyLine.get(i+1)[0];
                // Q(n)
                for (int l=0;l<firstheight;l++){
                    silhoutteArray[maxHeight-1-l][firstPosition] =1;
                }
                // Q(n)
                for (int l=firstPosition;l<secondPosition;l++){
                    silhoutteArray[maxHeight-firstheight][l] =1;// Q(1)
                }
                mid = maxHeight-firstheight;// Q(1)

                if(nextHeight> firstheight){// Q(1)
                    // Q(n)
                    for (int l= mid; l<mid-(nextHeight-firstheight);l--){// Q(1)
                        silhoutteArray[l][secondPosition]= 1;// Q(1)
                        flag1=l;// Q(1)
                    }
                    mid= flag1;// Q(1)

                }

                else{
                    // Q(n)
                    for (int l=mid; l< mid+ firstheight-nextHeight; l++){// Q(1)
                        silhoutteArray[l][secondPosition]= 1;// Q(1)
                        flag1=l;// Q(1)
                    }
                    mid= flag1;// Q(1)
                }
                flag=1;// Q(1)
            }
            else if(i < skyLine.size()-1 && flag==1){ // Q(1)
                Integer firstheight= skyLine.get(i)[1];// Q(1)
                Integer nextHeight= skyLine.get(i+1)[1];// Q(1)
                Integer firstPosition= skyLine.get(i)[0];// Q(1)
                Integer secondPosition= skyLine.get(i+1)[0];// Q(1)

                for (int l=firstPosition;l< secondPosition;l++){// Q(n)
                    silhoutteArray[mid][l]=1;// Q(1)
                }

                if (nextHeight>firstheight){// Q(1)
                    for (int l=mid;l>mid-nextHeight+firstheight;l--){ // Q(n)
                        silhoutteArray[l][secondPosition]=1;// Q(1)
                        flag1=l;// Q(1)
                    }
                    mid= flag1;// Q(1)
                }
                else{
                    for (int l=mid;l<mid + firstheight-nextHeight;l++){ // Q(n)
                        silhoutteArray[l][secondPosition]=1;// Q(1)
                        flag1=l;// Q(1)
                    }
                    mid= flag1;// Q(1)
                }
            }
        }

        /* printing the skyline */
        // Q(n^2)
        for (int i=0;i<maxHeight;i++){// Q(n)
            for(int j=0;j<number_of_coloumns;j++){// Q(n)
                if(silhoutteArray[i][j]==0){// Q(1)
                    System.out.print(" ");// Q(1)
                }
                else
                    System.out.print("*");// Q(1)
            }
            System.out.print("\n"); // Q(1)
        }
    }
}