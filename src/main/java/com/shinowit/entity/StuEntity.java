package com.shinowit.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2014/12/17.
 */
@Entity
@Table(name = "stu")
public class StuEntity {
    private int id;
    private String name;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    @Size(min = 3,max = 30,message = "用户名应介于3—30之间！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuEntity stuEntity = (StuEntity) o;

        if (id != stuEntity.id) return false;
        if (name != null ? !name.equals(stuEntity.name) : stuEntity.name != null) return false;
        if (password != null ? !password.equals(stuEntity.password) : stuEntity.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
