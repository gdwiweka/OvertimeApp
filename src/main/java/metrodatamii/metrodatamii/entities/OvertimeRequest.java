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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "overtime_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OvertimeRequest.findAll", query = "SELECT o FROM OvertimeRequest o")
    , @NamedQuery(name = "OvertimeRequest.findById", query = "SELECT o FROM OvertimeRequest o WHERE o.id = :id")
    , @NamedQuery(name = "OvertimeRequest.findByOvertimeDate", query = "SELECT o FROM OvertimeRequest o WHERE o.overtimeDate = :overtimeDate")
    , @NamedQuery(name = "OvertimeRequest.findByStartTime", query = "SELECT o FROM OvertimeRequest o WHERE o.startTime = :startTime")
    , @NamedQuery(name = "OvertimeRequest.findByEndTime", query = "SELECT o FROM OvertimeRequest o WHERE o.endTime = :endTime")
    , @NamedQuery(name = "OvertimeRequest.findByTotalHour", query = "SELECT o FROM OvertimeRequest o WHERE o.totalHour = :totalHour")
    , @NamedQuery(name = "OvertimeRequest.findByOSalary", query = "SELECT o FROM OvertimeRequest o WHERE o.oSalary = :oSalary")})
public class OvertimeRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overtime_date")
    @Temporal(TemporalType.DATE)
    private Date overtimeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_hour")
    private int totalHour;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "activity")
    private String activity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "o_salary")
    private int oSalary;
    @Lob
    @Column(name = "doc")
    private byte[] doc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "overtimeRequest", fetch = FetchType.LAZY)
    private List<OvertimeRequestStatus> overtimeRequestStatusList;
    @JoinColumn(name = "time_sheet", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TimeSheet timeSheet;
    @JoinColumn(name = "overtime_type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OvertimeType overtimeType;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    public OvertimeRequest() {
    }

    public OvertimeRequest(String id) {
        this.id = id;
    }

    public OvertimeRequest(String id, Date overtimeDate, Date startTime, Date endTime, int totalHour, String activity, int oSalary) {
        this.id = id;
        this.overtimeDate = overtimeDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalHour = totalHour;
        this.activity = activity;
        this.oSalary = oSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOvertimeDate() {
        return overtimeDate;
    }

    public void setOvertimeDate(Date overtimeDate) {
        this.overtimeDate = overtimeDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getOSalary() {
        return oSalary;
    }

    public void setOSalary(int oSalary) {
        this.oSalary = oSalary;
    }

    public byte[] getDoc() {
        return doc;
    }

    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    @XmlTransient
    public List<OvertimeRequestStatus> getOvertimeRequestStatusList() {
        return overtimeRequestStatusList;
    }

    public void setOvertimeRequestStatusList(List<OvertimeRequestStatus> overtimeRequestStatusList) {
        this.overtimeRequestStatusList = overtimeRequestStatusList;
    }

    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    public void setTimeSheet(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }

    public OvertimeType getOvertimeType() {
        return overtimeType;
    }

    public void setOvertimeType(OvertimeType overtimeType) {
        this.overtimeType = overtimeType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof OvertimeRequest)) {
            return false;
        }
        OvertimeRequest other = (OvertimeRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metrodatamii.metrodatamii.entities.OvertimeRequest[ id=" + id + " ]";
    }
    
}
