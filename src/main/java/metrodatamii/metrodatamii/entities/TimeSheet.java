/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "TimeSheet.findByPeriod", query = "SELECT t FROM TimeSheet t WHERE t.period = :period")
    , @NamedQuery(name = "TimeSheet.findByTotalHour", query = "SELECT t FROM TimeSheet t WHERE t.totalHour = :totalHour")})
public class TimeSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period")
    @Temporal(TemporalType.DATE)
    private Date period;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_hour")
    private int totalHour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeSheet", fetch = FetchType.LAZY)
    private List<OvertimeRequest> overtimeRequestList;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public TimeSheet() {
    }

    public TimeSheet(Integer id) {
        this.id = id;
    }

    public TimeSheet(Integer id, Date period, int totalHour) {
        this.id = id;
        this.period = period;
        this.totalHour = totalHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
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
