package fis.abcBank.dto.response;

public class CustomerResponse {
    private int customerID;
    private String customerName;
    private int customerPriority;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerPriority() {
        return customerPriority;
    }

    public void setCustomerPriority(int customerPriority) {
        this.customerPriority = customerPriority;
    }
}
