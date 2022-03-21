package com.src.main;

import java.util.Objects;
/**
 * market type building
 * @param <T>
 */

///// IMPORTANT: SINCE THERE IS NO LOOP INSIDE THIS CLASS, ALL OF THE ASSIGNMENTS ARE IN THE LINEAR TIME


public class Market <T> implements Building {
    private int openingTime;
    private int closingTime;
    private String owner;
    private int length;
    private int position;
    private int height;
    private String type;
    /**
     * @return getter for market type
     */
    public String getType() {
        return type;
    }
    /**
     * setter for the type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return lenght of the playground
     */
    public int getLength() {
        return length;
    }
    /**
     * @param length setter for the length
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * @return the position of the playground
     */
    public int getPosition() {
        return position;
    }
    /**
     * @param position setter for the position
     */
    public void setPosition(int position) {
        this.position = position;
    }
    /**
     * @return the height of the playground
     */
    public int getHeight() {
        return height;
    }
    /**
     * getter for closingTime
     * @return closingTime
     */
    public int getClosingTime() {
        return closingTime;
    }
    /**
     * setter for closingTime
     * @param closingTime
     */
    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * getter for openingTime
     * @return openingTime
     */
    public int getOpeningTime() {
        return openingTime;
    }
    /**
     * setter for openingTime
     * @param openingTime
     */
    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * getter for the owner parameter
     * @return the owner of the market
     */
    public String getOwner() {
        return owner;
    }

    /**
     * setter for the owner variable
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return the string correspondence of the com.src.main.Market building type
     */

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getFocusType(){
        return type;
    }

    /**
     * Default constructor for com.src.main.Market class which initializes the parameters as following: height=0,position=0,openingTime=0,closingTime=0,length=0, focustype="com.src.main.Market", owner =""
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public Market() {
        this.position=0;
        this.length=0;
        this.height=0;
        this.openingTime= 0;
        this.closingTime = 0;
        this.owner= "";
        this.type="com.src.main.Market";
    }

    private void checkInput(int length, int position, int height) throws Exception{
        if(length<0 || position<0 || height<0){
            throw new Exception("Invalid number");
        }
    }


    /**
     * Parametrized constructor for com.src.main.Market class which initializes the parameters as following: height=user_height_value,position=position,length=user_length_value, focustype="com.src.main.Market", owner= "user_owner_name"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */

    public Market(int length, int position, int height, int openingTime,int closingTime, String owner) throws Exception{
        this.length=length;
        this.type="com.src.main.Market";
        this.height=height;
        this.position=position;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
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
        return "com.src.main.Market{" +
                " owner='" + owner + '\'' +
                ", height='" + getHeight() + '\'' +
                ", length='" + getLength() + '\'' +
                ", openingTime='" + openingTime + '\'' +
                ", closingTime='" + closingTime + '\'' +
                ", position='" + getPosition() + '\'' +
                ", focusType=" +getFocusType() +
                '}';
    }
    /**
     * overridden equals method
     * @param o object has type com.src.main.Market
     * @return boolean value, true if two objects are equal false, if they are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market<?> market = (Market<?>) o;
        return getPosition() == market.getPosition() && getClosingTime() ==market.getClosingTime() && getOpeningTime() ==market.getOpeningTime()&& getLength() == market.getLength() && getHeight() == market.getHeight()  && Objects.equals(owner, market.owner) && Objects.equals(getFocusType(), market.getFocusType());
    }

}
