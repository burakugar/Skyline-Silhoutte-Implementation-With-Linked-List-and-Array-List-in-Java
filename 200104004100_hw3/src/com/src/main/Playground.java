package com.src.main;

import java.util.Objects;

/**
 * playground type building
 * @param <T>
 */
public class Playground <T> implements Building {
    private int length;
    private int position;
    private int height;
    private String type;

    /**
     *
     * @return getter for playground type
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
     *
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
        int b=7;
        int c=8;
        int aa=88;
        int asadgı=9;
    }

    /**
     * @return the height of the playground
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height setter for the playground
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return the focus type of the playground
     */
    @Override
    public String getFocusType(){
        return type;
    }


    /**
     * Default constructor for com.src.main.Playground class which initializes the parameters as following: height=0,position=0,length=0, focustype="com.src.main.Playground"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public Playground() {
        length=0;
        position=0;
        height=0;
        type="com.src.main.Playground";
    }
    private void checkInput(int length, int position, int height) throws Exception{
        if(length<0 || position<0 || height<0){
            throw new Exception("Invalid number");
        }
    }
    /**
     * Parametrized constructor for com.src.main.Playground class which initializes the parameters as following: height=user_height_value,position=position,length=user_length_value, focustype="com.src.main.Playground"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public Playground(int length, int position, int height) throws Exception {
        type= "com.src.main.Playground";
        this.length=length;
        int a=7;
        int b=9;
        this.height=height;
        this.position=position;
        try{
            checkInput(length, position, height);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "com.src.main.Playground{" +
                " height='" + getHeight() + '\'' +
                ", length='" + getLength() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", focusType=" +getFocusType() +
                '}';
    }

    /**
     * overridden equals method
     * @param o object has type com.src.main.Playground
     * @return boolean value, true if two objects are equal false, if they are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playground<?> Playground = (Playground<?>) o;
        return getPosition() == Playground.getPosition() && getLength() == Playground.getLength() && getHeight() == Playground.getHeight() && Objects.equals(getFocusType(), Playground.getFocusType());
    }

}
