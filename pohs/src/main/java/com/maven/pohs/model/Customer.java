/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.pohs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Edin Cekic
 */
@Entity
@Table(name = "CUSTOMER")

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idCustomer")
    private Integer idCustomer;

    @Column(name = "nameCustomer")
    private String nameCustomer;

    @Column(name = "passCustomer")
    private String passCustomer;

    @Column(name = "genderCustomer")
    private String genderCustomer;

    public Customer() {
    }

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(Integer idCustomer, String nameCustomer, String passCustomer, String genderCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.passCustomer = passCustomer;
        this.genderCustomer = genderCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPassCustomer() {
        return passCustomer;
    }

    public void setPassCustomer(String passCustomer) {
        this.passCustomer = passCustomer;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.maven.pohs.model.Customer[ idCustomer=" + idCustomer + " ]";
    }
    
}
