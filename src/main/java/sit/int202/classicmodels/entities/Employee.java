package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "employees")
@ToString
@NamedQueries(
        @NamedQuery(name = "EMPLOYEE.FINDALL", query = "select e from Employee e")
)
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;
}