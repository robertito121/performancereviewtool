/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Group 2
 */
public class PerformanceData {

    private String userID;
    private String year;
    private int measure1Rating;
    private String measure1Comment;
    private int measure2Rating;
    private String measure2Comment;
    private int measure3Rating;
    private String measure3Comment;
    private String additionalComments;
    
    public PerformanceData(String userID, String year, int measure1Rating, String measure1Comment, int measure2Rating, String measure2Comment, int measure3Rating, String measure3Comment, String additionalComments) {
        
        this.userID = userID;
        this.year = year;
        this.measure1Rating = measure1Rating;
        this.measure1Comment = measure1Comment;
        this.measure2Rating = measure2Rating;
        this.measure2Comment = measure2Comment;
        this.measure3Rating = measure3Rating;
        this.measure3Comment = measure3Comment;
        this.additionalComments = additionalComments;
    }
    
    public String getUserID() {
        
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the measure1Rating
     */
    public int getMeasure1Rating() {
        return measure1Rating;
    }

    /**
     * @param measure1Rating the measure1Rating to set
     */
    public void setMeasure1Rating(int measure1Rating) {
        this.measure1Rating = measure1Rating;
    }

    /**
     * @return the measure1Comment
     */
    public String getMeasure1Comment() {
        return measure1Comment;
    }

    /**
     * @param measure1Comment the measure1Comment to set
     */
    public void setMeasure1Comment(String measure1Comment) {
        this.measure1Comment = measure1Comment;
    }

    /**
     * @return the measure2Rating
     */
    public int getMeasure2Rating() {
        return measure2Rating;
    }

    /**
     * @param measure2Rating the measure2Rating to set
     */
    public void setMeasure2Rating(int measure2Rating) {
        this.measure2Rating = measure2Rating;
    }

    /**
     * @return the measure2Comment
     */
    public String getMeasure2Comment() {
        return measure2Comment;
    }

    /**
     * @param measure2Comment the measure2Comment to set
     */
    public void setMeasure2Comment(String measure2Comment) {
        this.measure2Comment = measure2Comment;
    }

    /**
     * @return the measure3Rating
     */
    public int getMeasure3Rating() {
        return measure3Rating;
    }

    /**
     * @param measure3Rating the measure3Rating to set
     */
    public void setMeasure3Rating(int measure3Rating) {
        this.measure3Rating = measure3Rating;
    }

    /**
     * @return the measure3Comment
     */
    public String getMeasure3Comment() {
        return measure3Comment;
    }

    /**
     * @param measure3Comment the measure3Comment to set
     */
    public void setMeasure3Comment(String measure3Comment) {
        this.measure3Comment = measure3Comment;
    }

    /**
     * @return the additionalComments
     */
    public String getAdditionalComments() {
        return additionalComments;
    }

    /**
     * @param additionalComments the additionalComments to set
     */
    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
    
    
}
