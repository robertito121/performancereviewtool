
package module4activity3.model;

public class PerformanceData {
    
    private PerformanceDataType performanceDataType;
    private PerformanceDataHistory performanceDataHistory;
    
    public PerformanceData(PerformanceDataType performanceDataType) {
        this.performanceDataType = performanceDataType;
    }

    /**
     * @return the performanceDataType
     */
    public PerformanceDataType getPerformanceDataType() {
        return performanceDataType;
    }

    /**
     * @param performanceDataType the performanceDataType to set
     */
    public void setPerformanceDataType(PerformanceDataType performanceDataType) {
        this.performanceDataType = performanceDataType;
    }

    /**
     * @return the performanceDataHistory
     */
    public PerformanceDataHistory getPerformanceDataHistory() {
        return performanceDataHistory;
    }

    /**
     * @param performanceDataHistory the performanceDataHistory to set
     */
    public void setPerformanceDataHistory(PerformanceDataHistory performanceDataHistory) {
        this.performanceDataHistory = performanceDataHistory;
    }
    
}
