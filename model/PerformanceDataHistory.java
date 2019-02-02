
package module4activity3.model;

import java.util.Date;

public class PerformanceDataHistory {
    
    private Date date;
    private Employee employee;
    
    public PerformanceDataHistory(Date date, Employee employee) {
        this.date = date;
        this.employee = employee;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
