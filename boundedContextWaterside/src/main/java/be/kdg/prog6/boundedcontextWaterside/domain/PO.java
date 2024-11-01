package be.kdg.prog6.boundedcontextWaterside.domain;

import java.time.LocalDate;
import java.util.List;

public class PO {
    private String poNumber;
    private POId poId;
    private LocalDate date;
    private Customer customer;
    private Seller seller;
    private String vesselNumber;
    private List<OrderItem> orderLines;
    private SO respectiveSO;

    public PO() {
    }

    public PO(String poNumber, POId poId, LocalDate date, Customer customer, Seller seller, String vesselNumber, List<OrderItem> orderLines, SO respectiveSO) {
        this.poNumber = poNumber;
        this.poId = poId;
        this.date = date;
        this.customer = customer;
        this.seller = seller;
        this.vesselNumber = vesselNumber;
        this.orderLines = orderLines;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public POId getPoId() {
        return poId;
    }

    public void setPoId(POId poId) {
        this.poId = poId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public List<OrderItem> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderItem> orderLines) {
        this.orderLines = orderLines;
    }

    public SO getRespectiveSO() {
        return respectiveSO;
    }

    public void setRespectiveSO(SO respectiveSO) {
        this.respectiveSO = respectiveSO;
    }
}
