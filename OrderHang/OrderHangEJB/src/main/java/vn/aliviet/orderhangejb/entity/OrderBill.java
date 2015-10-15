package vn.aliviet.orderhangejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by windluffy on 10/1/2015.
 */
@Entity
@Table(name = "order_bill", schema = "", catalog = "orderhang")
public class OrderBill {
    private int id;
    private Integer customerId;
    private Integer staffId;
    private Integer statusId;
    private Timestamp dateCreated;
    private User userByStaffId;
    private User userByCustomerId;
    private Status statusByStatusId;
    private Collection<Product> productsById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id", nullable = true, insertable = true, updatable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "staff_id", nullable = true, insertable = true, updatable = true)
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "status_id", nullable = true, insertable = true, updatable = true)
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "date_created", nullable = true, insertable = true, updatable = true)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderBill orderBill = (OrderBill) o;

        if (id != orderBill.id) return false;
        if (customerId != null ? !customerId.equals(orderBill.customerId) : orderBill.customerId != null) return false;
        if (staffId != null ? !staffId.equals(orderBill.staffId) : orderBill.staffId != null) return false;
        if (statusId != null ? !statusId.equals(orderBill.statusId) : orderBill.statusId != null) return false;
        if (dateCreated != null ? !dateCreated.equals(orderBill.dateCreated) : orderBill.dateCreated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    public User getUserByStaffId() {
        return userByStaffId;
    }

    public void setUserByStaffId(User userByStaffId) {
        this.userByStaffId = userByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public User getUserByCustomerId() {
        return userByCustomerId;
    }

    public void setUserByCustomerId(User userByCustomerId) {
        this.userByCustomerId = userByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @OneToMany(mappedBy = "orderBillByOrderId")
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }
}
