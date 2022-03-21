package com.src.main;

/**
 * interface for buildings
 * all buildings contains height, length, position and type parameters
 * getFocustype function returns a string that indicates an building's type
 * @param <T>
 */
public interface Building <T>{
    String getFocusType();
    public String getType();
    public void setType(String type);
    public int getLength();
    public void setLength(int length);
    public int getPosition();
    public void setPosition(int position);
    public int getHeight();
    public void setHeight(int height);

}
