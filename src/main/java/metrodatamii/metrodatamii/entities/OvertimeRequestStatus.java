/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erik
 */
@Entity
@Table(name = "overtime_request_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OvertimeRequestStatus.findAll", query = "SELECT o FROM OvertimeRequestStatus o")
    , @NamedQuery(name = "OvertimeRequestStatus.findById", query = "SELECT o FROM OvertimeRequestStatus o WHERE o.id = :id")
    , @NamedQuery(name = "OvertimeRequestStatus.findByStatusDate", query = "SELECT o FROM OvertimeRequestStatus o WHERE o.statusDate = :statusDate")})
public class OvertimeRequestStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "status_note")
    private String statusNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
    @JoinColumn(name = "overtime_request", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OvertimeRequest overtimeRequest;

    public OvertimeRequestStatus() {
    }

    public OvertimeRequestStatus(Integer id) {
        this.id = id;
    }

    public OvertimeRequestStatus(Integer id, String statusNote, Date statusDate) {
        this.id = id;
        this.statusNote = statusNote;
        this.statusDate = statusDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusNote() {
        return statusNote;
    }

    public void setStatusNote(String statusNote) {
        this.statusNote = statusNote;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OvertimeRequest getOvertimeRequest() {
        return overtimeRequest;
    }

    public void setOvertimeRequest(OvertimeRequest overtimeRequest) {
        this.overtimeRequest = overtimeRequest;
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
        if (!(object instanceof OvertimeRequestStatus)) {
            return false;
        }
        OvertimeRequestStatus other = (OvertimeRequestStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metrodatamii.metrodatamii.entities.OvertimeRequestStatus[ id=" + id + " ]";
    }
    
}
