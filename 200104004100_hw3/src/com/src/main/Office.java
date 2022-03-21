package com.src.main;

import java.util.Objects;
/**
 * office type building
 * @param <T>
 */
///// IMPORTANT: SINCE THERE IS NO LOOP INSIDE THIS CLASS, ALL OF THE ASSIGNMENTS ARE IN THE LINEAR TIME
public class Office <T> implements Building {
    private String jobType;
    private String owner;
    private int length;
    private int position;
    private int height;
    private String type;

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
     * @return lenght of the office
     */
    public int getLength() {
        return length;
    }
    /**
     *
     * @param length setter for the length
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     *
     * @return the position of the office
     */
    public int getPosition() {
        return position;
    }
    /**
     *
     * @param position setter for the position
     */
    public void setPosition(int position) {
        this.position = position;
    }
    /**
     *
     * @return the height of the office
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
     * @return the focus type of the office
     */
    @Override
    public String getFocusType(){
        return type;
    }

    private void checkInput(int length, int position, int height) throws Exception{
        if(length<0 || position<0 || height<0){
            throw new Exception("Invalid number");
        }
    }
    /**
     * Default constructor for com.src.main.House class which initializes the parameters as following: height=0,position=0,length=0, focustype="com.src.main.Office", jobType= "", owner= ""
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public Office() {
        this.position=0;
        this.length=0;
        this.height=0;
        this.jobType= "";
        this.owner = "";
        this.type="com.src.main.Office";

    }
    /**
     * Parametrized constructor for com.src.main.Office class which initializes the parameters as following: height=user_height_value,position=position,length=user_length_value, focustype="com.src.main.Office", jobType= "user_job_type", owner= "user_owner_name"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public Office(int length, int position, int height, String jobType, String owner) throws Exception{
        this.position=position;
        this.length=length;
        this.height=height;
        this.type="com.src.main.Office";
        this.jobType = jobType;
        this.owner = owner;
        try{
            checkInput(length, position, height);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * getter for jobType
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * setter for the jobType parameter
     * @param jobType
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * getter for the owner parameter
     * @return the owner of the house
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
     * @return the string correspondence of the com.src.main.Office building type
     */
    @Override
    public String toString() {
        return "com.src.main.Office{" +
                " jobType='" + jobType + '\'' +
                ", owner='" + owner + '\'' +
                ", height='" + getHeight() + '\'' +
                ", length='" + getLength() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", focusType=" + getFocusType() +
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
        Office<?> office = (Office<?>) o;
        return  getPosition() == office.getPosition() && getLength() == office.getLength() && getHeight() == office.getHeight()  && Objects.equals(jobType, office.jobType) && Objects.equals(owner, office.owner) && Objects.equals(getFocusType(), office.getFocusType());
    }

}
