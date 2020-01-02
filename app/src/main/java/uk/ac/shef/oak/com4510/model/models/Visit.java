package uk.ac.shef.oak.com4510.model.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * this is entity class uses to create a table in the room database
 * for visit
 * @author Areej
 */

@Entity(tableName = "visit")

public class Visit implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String title;
    private String description;
    private String date;
    private double longitude;
    private double latitude;
    private double temp;
    private double pressure;


    public Visit(){

    }
    public Visit(String title,String desc,String date, double longitude, double latitude, double temp, double pressure) {
        this.title = title;
        this.date = date;
        this.description=desc;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temp = temp;
        this.pressure = pressure;
    }
    public Visit(String title,String date, double longitude, double latitude, double temp, double pressure) {
        this.title = title;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temp = temp;
        this.pressure = pressure;
    }

    /**
     * to get the visit description
     * @return String
     */
    public String getDescription() {
        return description;
    }
    /**
     * to set the visit description
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * to get the visit id

     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * to set the visit id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * to return the visit title
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * to set the visit title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * to return the visit date
     * @return String
     */
    public String getDate() {
        return date;
    }

    /**
     * to set the date of the visit
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * to return the longitude of the visit
     * @return double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * to set the longitude of the visit location
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * to return the latitude of the visit
     * @return double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * to set the latitude of the visit location
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * to return the temperature of the visit location
     * @return double
     */
    public double getTemp() {
        return temp;
    }

    /**
     * to set the temperature of the visit location
     * @param temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * to return pressure of the visit location
     * @return
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * to set pressure of visit location
     * @param pressure
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
