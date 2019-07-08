/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erik
 */
@Entity
@Table(name = "overtime_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OvertimeType.findAll", query = "SELECT o FROM OvertimeType o")
    , @NamedQuery(name = "OvertimeType.findById", query = "SELECT o FROM OvertimeType o WHERE o.id = :id")
    , @NamedQuery(name = "OvertimeType.findByName", query = "SELECT o FROM OvertimeType o WHERE o.name = :name")
    , @NamedQuery(name = "OvertimeType.findByPercentage", query = "SELECT o FROM OvertimeType o WHERE o.percentage = :percentage")
    , @NamedQuery(name = "OvertimeType.findByIsDelete", query = "SELECT o FROM OvertimeType o WHERE o.isDelete = :isDelete")})
public class OvertimeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage")
    private float percentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_delete")
    private boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "overtimeType", fetch = FetchType.LAZY)
    private List<OvertimeRequest> overtimeRequestList;

    public OvertimeType() {
    }

    public OvertimeType(String id) {
        this.id = id;
    }

    public OvertimeType(String id, String name, float percentage, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<OvertimeRequest> getOvertimeRequestList() {
        return overtimeRequestList;
    }

    public void setOvertimeRequestList(List<OvertimeRequest> overtimeRequestList) {
        this.overtimeRequestList = overtimeRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OvertimeType)) {
            return false;
        }
        OvertimeType other = (OvertimeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metrodatamii.metrodatamii.entities.OvertimeType[ id=" + id + " ]";
    }
    
}
