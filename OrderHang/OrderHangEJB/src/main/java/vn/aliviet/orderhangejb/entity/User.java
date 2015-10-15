package vn.aliviet.orderhangejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by windluffy on 10/1/2015.
 */
@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private Boolean isActive;
    private Integer roleId;
    private Timestamp dateCreated;
    private Collection<OrderBill> orderBillsById;
    private Collection<OrderBill> orderBillsById_0;
    private Role roleByRoleId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "is_active", nullable = true, insertable = true, updatable = true)
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "role_id", nullable = true, insertable = true, updatable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (isActive != null ? !isActive.equals(user.isActive) : user.isActive != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        if (dateCreated != null ? !dateCreated.equals(user.dateCreated) : user.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByStaffId")
    public Collection<OrderBill> getOrderBillsById() {
        return orderBillsById;
    }

    public void setOrderBillsById(Collection<OrderBill> orderBillsById) {
        this.orderBillsById = orderBillsById;
    }

    @OneToMany(mappedBy = "userByCustomerId")
    public Collection<OrderBill> getOrderBillsById_0() {
        return orderBillsById_0;
    }

    public void setOrderBillsById_0(Collection<OrderBill> orderBillsById_0) {
        this.orderBillsById_0 = orderBillsById_0;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
