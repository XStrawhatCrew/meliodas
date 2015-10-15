package vn.aliviet.orderhangejb.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by windluffy on 10/1/2015.
 */
@Entity
public class Status {
    private int id;
    private String title;
    private Collection<OrderBill> orderBillsById;
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
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (id != status.id) return false;
        if (title != null ? !title.equals(status.title) : status.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<OrderBill> getOrderBillsById() {
        return orderBillsById;
    }

    public void setOrderBillsById(Collection<OrderBill> orderBillsById) {
        this.orderBillsById = orderBillsById;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }
}
