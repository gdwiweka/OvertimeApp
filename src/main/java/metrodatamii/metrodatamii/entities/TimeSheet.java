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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author ASUS
 */
@Entity
@Table(name = "time_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeSheet.findAll", query = "SELECT t FROM TimeSheet t")
    , @NamedQuery(name = "TimeSheet.findById", query = "SELECT t FROM TimeSheet t WHERE t.id = :id")
    , @NamedQuery(name = "TimeSheet.findByTotalHour", query = "SELECT t FROM TimeSheet t WHERE t.totalHour = :totalHour")})
public class TimeSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id")
    private String id;
    @Column(name = "total_hour")
    private Integer totalHour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeSheet", fetch = FetchType.LAZY)
    private List<OvertimeRequest> overtimeRequestList;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public TimeSheet() {
    }

    public TimeSheet(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Integer totalHour) {
        this.totalHour = totalHour;
    }

    @XmlTransient
    public List<OvertimeRequest> getOvertimeRequestList() {
        return overtimeRequestList;
    }

    public void setOvertimeRequestList(List<OvertimeRequest> overtimeRequestList) {
        this.overtimeRequestList = overtimeRequestList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof TimeSheet)) {
            return false;
        }
        TimeSheet other = (TimeSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metrodatamii.metrodatamii.entities.TimeSheet[ id=" + id + " ]";
    }
    
}
