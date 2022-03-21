package com.src.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Street represents one side of the street
 */
// TOTAL RUNNING TIME: Q(n^2)
public class StreetArrayList {
    /**
     * building array is the array contains all the buildings in one side of the street
     */
    private int length;
    private int size;
    private ArrayList<Building> buildingArray;
    private ArrayList<Integer> positionList;

    /**
     * no parameter constructor for Street
     */
    public StreetArrayList() {
        this.length = 0;
        buildingArray = new ArrayList<Building>();
        size = 0;
    }

    /**
     *
     * @return the size of the Street which is the number of buildings
     */
    public int getSize() {
        return size;
    }
    /**
     *
     * setter for the number of buildings in the street
     */
    public void setSize(int size) {
        this.size = size;
    }
    public Integer[] append(Integer[] array, int element){
        int len= array.length;
        Integer[] temp =new Integer[len+1];
        for(int i=0;i<len;i++){
            temp[i]= array[i];
        }
        temp[len]= element;
        len++;
        array= new Integer[len];
        for(int i=0;i<len;i++){
            array[i]= temp[i];
        }
        return array;
    }

    /**
     *
     * @param length is the length of the street
     * @param buildingArray is the array has the buildings in it which is then will be added into the street
     * @param size is the number of buildings in the street( one side)
     * @throws Exception if the size of the array given is not equal to size of the Street throws exception
     */

    public StreetArrayList(int length, ArrayList<Building> buildingArray, int size) throws Exception {
        if(size != buildingArray.size()){
            throw new Exception("Street size is different than array size!");
        }
        this.length = length;
        this.buildingArray = buildingArray;
        this.size = size;
        positionList = new ArrayList<Integer>();
        for (int i = 0; i < buildingArray.size(); i++) {
            for (int j = buildingArray.get(i).getPosition(); j < buildingArray.get(i).getPosition() + buildingArray.get(i).getLength() + 1; j++) {
               positionList.add(j);
            }
        }
    }

    public int getLength() {
        return length;
    }

    /**
     *
     * @param length setter for length of the street
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     *
     * @return the building array in the street
     */

    public ArrayList<Building> getBuildingArray() {
        return buildingArray;
    }

    /***
     *
     * @param buildingArray setter for building array
     */
    public void setBuildingArray(ArrayList<Building> buildingArray) {
        this.buildingArray = buildingArray;
    }


    /***
     * prints the buildings to screen
     */
    public void showBuildings() {
        Building building, building_max;
        int max_position = buildingArray.get(0).getPosition(); // Q(1)
        int index_max = 0;// Q(1)
        int len = buildingArray.size(); // Q(1)
        for (int i = 0; i < len - 1; i++)  // Q(n^2)
            for (int j = 0; j < len - i - 1; j++)
                if (buildingArray.get(j).getPosition() >buildingArray.get(j+1).getPosition()) {
                    building = buildingArray.get(j);
                    buildingArray.set(j,buildingArray.get(j + 1));
                    buildingArray.set(j+1,building);
                }
        System.out.println("******************************");
        System.out.println("Buildings in the street are: ");
        for (int i = 0; i < len; i++) { // Q(n)
            System.out.println((i + 1) + "."+ " " +buildingArray.get(i));
        }
    }

    /**
     * finds the empty areas in the street, prints their locations and lenghts
     */
    public void findEmptyAreas() { //  Overall Q(n^2)
        int[] lengthArray = new int[length]; // Q(1)
        int k = 0;// Q(1)
        for (int i = 0; i < size; i++) { // Q(n^2)
            int startPoint = buildingArray.get(i).getPosition();
            for (int j = startPoint; j < startPoint + buildingArray.get(i).getLength(); j++) {
                lengthArray[k] = j;
                k++;
            }
        }
        int sizeofFilledArray = k;
        /* filledArray holds the positions that is filled by buildings on the street */
        int[] filledArray = new int[sizeofFilledArray]; // Q(1)
        for (int i = 0; i < sizeofFilledArray; i++) { // Q(n)
            filledArray[i] = lengthArray[i]; // Q(1)
        }

        int[] emptyAreas = new int[length - k]; // Q(1)
        int l = 0; // Q(1)
        for (int i = 0; i < length; i++) { // Q(n^2)
            int flag = 0;
            for (int j = 0; j < k; j++) {
                if (i == filledArray[j]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                emptyAreas[l] = i;
                l++;
            }
        }
        /**
         * position array holds the positions of the buildings
         */
        int[] positionArray = new int[size]; // Q(1)
        for (int i = 0; i < size; i++) { // Q(n^2)
            positionArray[i] = buildingArray.get(i).getPosition();
        }
        Arrays.sort(emptyAreas);
        Arrays.sort(positionArray);
        k = 0;
        for (int i = 0; i < emptyAreas.length; i++) { // Q(n^2)
            for (int j = 0; j < positionArray.length; j++) {
                if (emptyAreas[i] < positionArray[j]) {
                    int dif = positionArray[j] - emptyAreas[i];
                    System.out.println("Empty position: " + emptyAreas[i] + " " + "with length " + dif);
                    break;
                }
            }
        }

    }

    /**
     * calculates the total number of remaining length on the street and prints using filledArray
     */
    public void calculateTotalNumberofRemainingLength() { // Q(n^2)

        int[] lengthArray = new int[length]; // Q(1)
        int k = 0;// Q(1)
        for (int i = 0; i < size; i++) { // Q(n^2)
            int startPoint = buildingArray.get(i).getPosition();
            for (int j = startPoint; j < startPoint + buildingArray.get(i).getLength(); j++) { // Q(n)
                lengthArray[k] = j;// Q(1)
                k++;// Q(1)
            }
        }
        int sizeofFilledArray = k;// Q(1)
        int[] filledArray = new int[sizeofFilledArray];// Q(1)
        for (int i = 0; i < sizeofFilledArray; i++) { // Q(n)
            filledArray[i] = lengthArray[i];// Q(1)
        }

        int[] emptyAreas = new int[length - k];// Q(1)
        int l = 0;// Q(1)
        for (int i = 0; i < length; i++) {// Q(n^2)
            int flag = 0;// Q(1)
            for (int j = 0; j < k; j++) {// Q(n)
                if (i == filledArray[j]) {// Q(1)
                    flag = 1;// Q(1)
                }
            }
            if (flag == 0) {// Q(1)
                emptyAreas[l] = i;// Q(1)
                l++;// Q(1)
            }
        }
        System.out.println("Total number of empty field is : " + emptyAreas.length);// Q(1)
    }

    /**
     * calculates the ratio of the playgrounds on the street and prints it
     */
    public void calculateNumberandRatioofPlaygrounds() {
        int totalLengthofHouses = 0; // Q(1)
        int totalLengthofMarkets = 0; // Q(1)
        int totalLengthofPlaygrounds = 0; // Q(1)
        int totalLengthofOffices = 0; // Q(1)
        int numberofPlaygrounds = 0; // Q(1)
        for (int i = 0; i < size; i++) { // Q(n)
            if (buildingArray.get(i).getType() == "com.src.main.House") {
                totalLengthofHouses += buildingArray.get(i).getLength();
            } else if (buildingArray.get(i).getType() == "com.src.main.Market") {
                totalLengthofMarkets += buildingArray.get(i).getLength();
            } else if (buildingArray.get(i).getType() == "com.src.main.Office") {
                totalLengthofOffices += buildingArray.get(i).getLength();
            } else if (buildingArray.get(i).getType() == "com.src.main.Playground") {
                totalLengthofPlaygrounds += buildingArray.get(i).getLength();
                numberofPlaygrounds++;
            }
        }
        float ratio = (float) totalLengthofPlaygrounds / (totalLengthofMarkets + totalLengthofOffices + totalLengthofHouses + totalLengthofPlaygrounds) * 100; // Q(1)
        System.out.println("Total playground ratio in the street is : " + ratio);// Q(1)
        System.out.println("Number of playground in the street is: " + numberofPlaygrounds);// Q(1)
    }

    /**
     * calculates the total number of non-playgorund obhects in the street
     */
    public void calculatetotalNumberofNonPlaygrounds() { // Q(n)
        int numberofMarkets = 0; // Q(1)
        int numberofHouses = 0; // Q(1)
        int numberofOffices = 0; // Q(1)
        int numberofPlaygrounds = 0; // Q(1)
        for (int i = 0; i < size; i++) { // Q(n)
            if (buildingArray.get(i).getType() == "com.src.main.House") { // Q(1)
                numberofHouses++; // Q(1)
            } else if (buildingArray.get(i).getType() == "com.src.main.Market") {// Q(1)
                numberofMarkets++;// Q(1)
            } else if (buildingArray.get(i).getType() == "com.src.main.Office") {// Q(1)
                numberofOffices++;
            }
        }
        System.out.println("Number of non-playground buildings in the street is: " + Integer.toString(numberofHouses + numberofMarkets + numberofOffices)); // Q(1)
    }

    /**
     * controls whether a given number is negative or not
     * @param number hat will be checked
     * @return 1 if not negative else returns 0
     * used in exception handling
     */
    private int inputCheckNumber(int number) { // Q(1)
        if (number < 0) { // Q(1)
            System.out.println("Invalid number"); // Q(1)
            return -1; // Q(1)
        }
        else
            return 1; // Q(1)
    }

    /**
     *  Adds a house to the street
     * @param height of the house to be added
     * @param length of the house to be added
     * @param position of the house to be added
     * @param numberofRoooms of the house to be added
     * @param color of the house to be added
     * @param owner of the house to be added
     * @throws Exception if the house's position is not free or the given parameters not compatible
     */
    public void addHouse(int height, int length, int position, int numberofRoooms, String color, String owner) throws Exception {
        int flag = 0; // Q(1)
        // Double for loop Q(n^2)
        for (int i = 0; i < positionList.size(); i++) { // Q(n)
            for (int j = position; j < position + length; j++) { // Q(n)
                if (j == positionList.get(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) { // Q(1)
                break;
            }
        }
        if (flag==1)
            throw new Exception("Invalid position"); // Q(1)

        inputCheckNumber(numberofRoooms); // Q(1)
        /**
         * controlling whether the given house is eligible to be created or not with given parameters
         */
        try{
            House newHouse = new House(length, position, height, numberofRoooms, color, owner); // Q(1)
        }
        catch (Exception e) {
            e.printStackTrace();// Q(1)
        }

        House newHouse = new House(length, position, height, numberofRoooms, color, owner);// Q(1)
        buildingArray.add(newHouse);// Q(1)
        size= buildingArray.size();// Q(1)
        for (int i = buildingArray.get(size - 1).getPosition(); i < buildingArray.get(size - 1).getPosition() + buildingArray.get(size - 1).getLength(); i++) {
            positionList.add(i);// Q(1)
        }
    }

    /**
     *  Adds an office to the street
     * @param height of the office to be added
     * @param length of the office to be added
     * @param position of the office to be added
     * @param jobType of the office to be added
     * @param owner of the office to be added
     * @throws Exception if the office's position is not free or the given parameters not compatible
     */
    public void addOffice(int height, int length, int position, String jobType, String owner) throws Exception { // Q(n^2)
        int flag = 0; // Q(1)
        for (int i = 0; i < positionList.size(); i++) { // Q(n^2)
            for (int j = position; j < position + length; j++) {
                if (j == positionList.get(i)) {// Q(1)
                    System.out.println("Invalid position");// Q(1)
                    flag = 1;// Q(1)
                    break;// Q(1)
                }
            }
            if (flag == 1) {// Q(1)
                break;// Q(1)
            }
        }
        if (flag==1)
            throw new Exception("Invalid position");// Q(1)

        /**
         * controlling whether the given house is eligible to be created or not with given parameters
         */
        Office newOffice = new Office(length, position, height, jobType, owner);// Q(1)

        try{
            newOffice = new Office(length, position, height, jobType, owner);// Q(1)
        }
        catch (Exception e) {
            e.printStackTrace();// Q(1)
        }

        buildingArray.add(newOffice);// Q(1)
        size= buildingArray.size();// Q(1)
        // Q(n)
        for (int i = buildingArray.get(size - 1).getPosition(); i < buildingArray.get(size - 1).getPosition() + buildingArray.get(size - 1).getLength(); i++) {
            positionList.add(i);
        }
    }

    /**
     *  Adds an market to the street
     * @param height of the market to be added
     * @param length of the market to be added
     * @param position of the market to be added
     * @param openingTime of the market to be added
     * @param closingTime of the market to be added
     * @param owner of the market to be added
     * @throws Exception if the market's position is not free or the given parameters not compatible
     */
    public void addMarket(int height, int length, int position, int openingTime, int closingTime,String owner) throws Exception {
        int flag = 0; // Q(1)
        for (int i = 0; i < positionList.size(); i++) { // Q(n^2)
            for (int j = position; j < position + length; j++) { // Q(1)
                if (j == positionList.get(i)) { // Q(1)
                    System.out.println("Invalid position"); // Q(1)
                    flag = 1;// Q(1)
                    break;
                }
            }
            if (flag == 1) {
                break;// Q(1)
            }
        }
        if (flag==1)
            throw new Exception("Invalid position");// Q(1)

        Market newMarket = new Market(length, position, height,openingTime,closingTime,owner);// Q(1)
        try{
            newMarket = new Market(length, position, height,openingTime,closingTime,owner);// Q(1)
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        buildingArray.add(newMarket);// Q(1)
        size= buildingArray.size();// Q(1)
        // Q(n)
        for (int i = buildingArray.get(size - 1).getPosition(); i < buildingArray.get(size - 1).getPosition() + buildingArray.get(size - 1).getLength(); i++) {
            positionList.add(i);
        }

    }
    /**
     *  Adds an playground to the street
     * @param height of the playground to be added
     * @param length of the playground to be added
     * @param position of the playground to be added
     * @throws Exception if the playground's position is not free or the given parameters not compatible
     */
    // Q(n^2)
    public void addPlayground(int height, int length, int position) throws Exception {
        int flag = 0; // Q(1)
        for (int i = 0; i < positionList.size(); i++) {// Q(n^2)
            for (int j = position; j < position + length; j++) { // Q(n)
                if (j == positionList.get(i)) { // Q(1)
                    System.out.println("Invalid position");// Q(1)
                    flag = 1;// Q(1)
                    break;// Q(1)
                }
            }
            if (flag == 1) {// Q(1)
                break;// Q(1)
            }
        }
        Playground newPlayground = new Playground(length, position,height);// Q(1)

        if (flag==1)
            throw new Exception("Invalid position");// Q(1)

        try{
            newPlayground = new Playground(length, position, height);// Q(1)
        }
        catch (Exception e) {// Q(1)
            e.printStackTrace();// Q(1)
        }


        size++;
        buildingArray.add(newPlayground);
        size= buildingArray.size();
        for (int i = buildingArray.get(size - 1).getPosition(); i < buildingArray.get(size - 1).getPosition() + buildingArray.get(size - 1).getLength(); i++) {
            positionList.add(i);
        }
    }

    /**
     * Deletes a playground from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the playground will be deleted
     * @throws Exception if given position is not valid
     */
    // Q(n^2)
    public void deletePlayground(int position) throws Exception{
        int flag=0;// Q(1)
        int lengthofPlayground=0; // Q(1)
        int positionofPlayground=0;// Q(1)
        int deleted_index=0;// Q(1)
        for (int i=0;i<buildingArray.size();i++) {// Q(n^2)
            if (buildingArray.get(i).getType() == "com.src.main.Playground" && buildingArray.get(i).getPosition() == position) {
                flag=1;// Q(1)
                lengthofPlayground=buildingArray.get(i).getLength();// Q(1)
                positionofPlayground=position;// Q(1)
                size--;// Q(1)
                deleted_index=i;// Q(1)
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }

        buildingArray.remove(deleted_index);// Q(1)
        for (int i=0;i<positionList.size();i++){// Q(n^2)
            if(positionList.get(i)==positionofPlayground){ // Q(1)
                for (int j=i+lengthofPlayground-1;j>i-1;j--){// Q(n)
                    positionList.remove(j);// Q(1)
                }
                break;// Q(1)
            }
        }
        System.out.println("com.src.main.Playground is deleted from the position " + position);// Q(1)
    }
    /**
     * Deletes a market from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the market will be deleted
     * @throws Exception if given position is not valid
     */
    // Q(n^2)
    public void deleteMarket(int position) throws Exception{
        int flag=0; // Q(1)
        int lengthofMarket=0;// Q(1)
        int positionofMarket=0;// Q(1)
        int deleted_index=0;// Q(1)
        for (int i=0;i<buildingArray.size();i++) { // Q(n)
            if (buildingArray.get(i).getType() == "com.src.main.Market" && buildingArray.get(i).getPosition() == position) {
                flag=1;// Q(1)
                lengthofMarket=buildingArray.get(i).getLength();// Q(1)
                positionofMarket=position;// Q(1)
                size--;// Q(1)
                deleted_index=i;// Q(1)
            }
        }
        if(flag==0) {// Q(1)
            throw new Exception("Invalid position");// Q(1)
        }

        buildingArray.remove(deleted_index);// Q(1)
        for (int i=0;i<positionList.size();i++){// Q(n^2)
            if(positionList.get(i)==positionofMarket){// Q(1)
                for (int j=i+lengthofMarket-1;j>i-1;j--){// Q(n)
                    positionList.remove(j);// Q(1)
                }
                break;// Q(1)
            }
        }
        System.out.println("com.src.main.Market is deleted from the position " + position);// Q(1)
    }
    /**
     * Deletes a office from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the office will be deleted
     * @throws Exception if given position is not valid
     */
    // Q(n^2)
    public void deleteOffice(int position) throws Exception {
        int flag=0;
        int lengthofOffice=0;
        int positionofOffice=0;
        int deleted_index=0;
        for (int i=0;i<buildingArray.size();i++) {
            if (buildingArray.get(i).getType() == "com.src.main.Office" && buildingArray.get(i).getPosition() == position) {
                flag=1;
                lengthofOffice=buildingArray.get(i).getLength();
                positionofOffice=position;
                size--;
                deleted_index=i;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }

        buildingArray.remove(deleted_index);
        for (int i=0;i<positionList.size();i++){
            if(positionList.get(i)==positionofOffice){
                for (int j=i+lengthofOffice-1;j>i-1;j--){
                    positionList.remove(j);
                }
                break;
            }
        }
        System.out.println("com.src.main.Office is deleted from the position " + position);
    }
    /**
     * Deletes a house from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the house will be deleted
     * @throws Exception if given position is not valid
     */
    // Q(n^2)
    public void deleteHouse(int position) throws Exception {
        int flag=0;
        int lengthofHouse=0;
        int positionofHouse=0;
        int deleted_index=0;
        for (int i=0;i<buildingArray.size();i++) {
            if (buildingArray.get(i).getType() == "com.src.main.House" && buildingArray.get(i).getPosition() == position) {
                flag=1;
                lengthofHouse=buildingArray.get(i).getLength();
                positionofHouse=position;
                size--;
                deleted_index=i;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }

        buildingArray.remove(deleted_index);
        for (int i=0;i<positionList.size();i++){
            if(positionList.get(i)==positionofHouse){
                for (int j=i+lengthofHouse-1;j>i-1;j--){
                    positionList.remove(j);
                }
                break;
            }
        }
        System.out.println("com.src.main.House is deleted from the position " + position);
    }
    // Q(1)
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

