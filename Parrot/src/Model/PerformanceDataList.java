/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PerformanceDataList {

    private Map<String, ArrayList<PerformanceData>> performanceDataMap = new HashMap<>();
    private String fileName = "performanceDataList.ser";

    /**
     * constructor
     */
    public PerformanceDataList() {
        readPerformanceDataListFromFile();
        if (performanceDataMap.isEmpty() || performanceDataMap == null) {
            populatePerformanceData();
            writePerformanceDataListToFile();
            readPerformanceDataListFromFile();
        }
    }

    /**
     * Adds performanceData into the HashMap by UserId
     * @param userId
     * @param data
     */
    public void addPerformanceDatatoHashMap(String userId, PerformanceData data) {
        ArrayList<PerformanceData> dataList = getPerformanceDataByUserId(userId);
        dataList.add(data);
        performanceDataMap.put(userId, dataList);
        writePerformanceDataListToFile();
    }

    /**
     * Gets an ArrayList of PerformanceData by UserId
     * @param userId
     * @return
     */
    public ArrayList<PerformanceData> getPerformanceDataByUserId(String userId) {
        setInstanceCounterToLastSetValue(userId);
        return performanceDataMap.get(userId);
    }

    /**
     * Populates initial data
     */
    public void populatePerformanceData() {
        UserList userList = new UserList();
        ArrayList<User> users = userList.getUserList();

        for (User user : users) {
            ArrayList<PerformanceData> data = new ArrayList<>();
            createUserPlaceHolder(user.userId, data);
        }
    }

    /**
     * Creates a user placeholder in the Map for new PerformanceData to be inserted
     * @param userId
     * @param data
     */
    public void createUserPlaceHolder(String userId, ArrayList<PerformanceData> data) {
        if (performanceDataMap.get(userId) == null) {
            performanceDataMap.put(userId, data);
            performanceDataMap.put(userId, data);
        }
    }

    /**
     * reads performanceData from file
     */
    private void readPerformanceDataListFromFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            performanceDataMap = (Map) in.readObject();
            in.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * writes performanceData to file
     */
    private void writePerformanceDataListToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(performanceDataMap);
            out.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Set the instanceCounter to the last known set value for each user
     * @param userId
     */
    public void setInstanceCounterToLastSetValue(String userId) {

       ArrayList<PerformanceData> data = performanceDataMap.get(userId);
       PerformanceData.setInstanceCounter(data.size());
    }

    public Map<String, ArrayList<PerformanceData>> getPerformanceDataMap() {
        return performanceDataMap;
    }

    public void setPerformanceDataMap(Map<String, ArrayList<PerformanceData>> performanceDataMap) {
        this.performanceDataMap = performanceDataMap;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
