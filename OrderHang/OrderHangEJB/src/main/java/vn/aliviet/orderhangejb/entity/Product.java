package vn.aliviet.orderhangejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by windluffy on 10/1/2015.
 */
@Entity
public class Product {
    private int id;
    private String linkSource;
    private String shopName;
    private String color;
    private String notes;
    private String size;
    private Integer quantity;
    private Integer price;
    private Integer statusId;
    private Integer orderId;
    private Timestamp dateCreated;
    private OrderBill orderBillByOrderId;
    private Status statusByStatusId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link_source", nullable = true, insertable = true, updatable = true, length = 500)
    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }

    @Basic
    @Column(name = "shop_name", nullable = true, insertable = true, updatable = true, length = 200)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "color", nullable = true, insertable = true, updatable = true, length = 30)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "notes", nullable = true, insertable = true, updatable = true, length = 500)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "size", nullable = true, insertable = true, updatable = true, length = 10)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "quantity", nullable = true, insertable = true, updatable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    @Column(name = "order_id", nullable = true, insertable = true, updatable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (linkSource != null ? !linkSource.equals(product.linkSource) : product.linkSource != null) return false;
        if (shopName != null ? !shopName.equals(product.shopName) : product.shopName != null) return false;
        if (color != null ? !color.equals(product.color) : product.color != null) return false;
        if (notes != null ? !notes.equals(product.notes) : product.notes != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (statusId != null ? !statusId.equals(product.statusId) : product.statusId != null) return false;
        if (orderId != null ? !orderId.equals(product.orderId) : product.orderId != null) return false;
        if (dateCreated != null ? !dateCreated.equals(product.dateCreated) : product.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (linkSource != null ? linkSource.hashCode() : 0);
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public OrderBill getOrderBillByOrderId() {
        return orderBillByOrderId;
    }

    public void setOrderBillByOrderId(OrderBill orderBillByOrderId) {
        this.orderBillByOrderId = orderBillByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }
}
