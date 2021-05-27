package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name="reports")
@NamedQueries({
    @NamedQuery(name="getAllReports",
            query="SELECT r FROM Report AS r ORDER BY r.id DESC"
            ),
@NamedQuery(
        name="getAllReportsCount",
        query="SELECT COUNT(r) FROM Report AS r"
        ),
@NamedQuery(
        name="getMyAllReports",
        query="SELECT r FROM Report AS r WHERE r.employee =:employee ORDER BY r.id DESC"
        ),
    @NamedQuery(
            name="getMyReportsCount",
            query="SELECT COUNT(r) FROM Report AS r WHERE r.employee=:employee"
            ),
    @NamedQuery(
            name="getMyTodayReport",
            query="SELECT r FROM Report AS r WHERE r.employee=:employee AND r.report_date=:workDay"
            ),
    @NamedQuery(
            name="getMyLastReport",
            query="SELECT r FROM Report AS r WHERE r.employee=:employee AND r.report_date <>:workingDay ORDER BY r.id DESC "
            )
})
@Entity

public class Report {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="employee_id",nullable=false)
    private Employee employee;

    @Column(name="report_date",nullable=false)
    private Date report_date;

    @Lob
    @Column(name="content",nullable=false)
    private String content;

    @Column(name="created_at",nullable=false)
    private Timestamp created_at;

    @Column(name="updated_at",nullable=false)
    private Timestamp updated_at;

    @Column(name="company",nullable=false)
    private String company;

    @Column(name="plan",nullable=false)
    private String plan;



    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }





}
