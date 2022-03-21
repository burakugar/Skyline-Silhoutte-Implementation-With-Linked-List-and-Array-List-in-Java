package com.src.main;

import java.util.Objects;
/**
 * house type building
 * @param <T>
 */
///// IMPORTANT: SINCE THERE IS NO LOOP INSIDE THIS CLASS, ALL OF THE ASSIGNMENTS ARE IN THE LINEAR TIME
public class House<T> implements Building {
    private int numberOfRooms;// Q(1)
    private String color;// Q(1)
    private String owner;// Q(1)
    private int length;// Q(1)
    private int position;// Q(1)
    private int height;// Q(1)
    private String type;// Q(1)

    /**
     *
     * @return the type of the house
     */
    public String getType() {
        return type;
    }// Q(1)
    /**
     *
     * @return setter for the house type
     */
    public void setType(String type) {
        this.type = type;
    }// Q(1)
    /**
     *
     * @return lenght of the house
     */
    public int getLength() {
        return length;
    }// Q(1)
    /**
     *
     * @param length setter for the length
     */
    public void setLength(int length) {
        this.length = length;
    }// Q(1)
    /**
     *
     * @return the position of the house
     */
    public int getPosition() {
        return position;
    }// Q(1)
    /**
     *
     * @param position setter for the house
     */
    public void setPosition(int position) {
        this.position = position;
    }// Q(1)
    /**
     *
     * @return the height of the house
     */
    public int getHeight() {
        return height;
    }// Q(1)
    /**
     *
     * @param height setter for the house
     */

    public void setHeight(int height) {
        this.height = height;
    }// Q(1)

    @Override
    public String getFocusType(){
        return type;
    }// Q(1)
    /**
     * getter for numberofrooms
     * @return numberofrooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }// Q(1)
    /**
     * setter for numberofrooms
     * @param numberOfRooms
     */
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }// Q(1)

    /**
     * getter for color
     * @return the color
     */
    public String getColor() {
        return color;
    }// Q(1)

    /**
     * setter for the color parameter
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }// Q(1)

    /**
     * getter for the owner parameter
     * @return the owner of the house
     */
    public String getOwner() {
        return owner;
    }// Q(1)

    /**
     * setter for the owner variable
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }// Q(1)

    /**
     *
     * @return the string correspondence of the com.src.main.House building type
     */

    /**
     * Default constructor for com.src.main.House class which initializes the parameters as following: height=0,position=0,numberofrooms=0,length=0, focustype="com.src.main.House", color= "", owner= ""
     length,position,height and focusType belongs to base class so we use base class constructor.
     */

    public House() {
        this.position=0;
        this.length=0;
        this.height=0;
        this.color= "";
        this.owner = "";
        this.numberOfRooms=0;
        this.type="com.src.main.House";
    }
    private void checkInput(int length, int position, int height) throws Exception{
        if(length<0 || position<0 || height<0){
            throw new Exception("Invalid number");
        }
    }
    /**
     * Parametrized constructor for com.src.main.House class which initializes the parameters as following: height=user_height_value,position=position,numberofrooms=user_numberofrooms_value,length=user_length_value, focustype="com.src.main.House", color= "user_color_value", owner= "user_owner_name"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public House(int length, int position, int height, int numberOfRooms, String color, String owner)throws Exception {
        this.length=length;
        this.type="com.src.main.House";
        this.height=height;
        this.position=position;
        this.numberOfRooms = numberOfRooms;
        this.color = color;
        this.owner = owner;
        try{
            checkInput(length, position, height);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "com.src.main.House{" +
                " numberOfRooms=" + numberOfRooms +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                ", height='" + getHeight() + '\'' +
                ", length='" + getLength() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", focusType=" +getFocusType() +
                '}';
    }

    /**
     * overridden equals method
     * @param o object has type com.src.main.House
     * @return boolean value, true if two objects are equal false, if they are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House<?> house = (House<?>) o;
        return numberOfRooms == house.numberOfRooms && getPosition() == house.getPosition() && getLength() == house.getLength() && getHeight() == house.getHeight()  && Objects.equals(color, house.color) && Objects.equals(owner, house.owner) && Objects.equals(getFocusType(), house.getFocusType());
    }

}
