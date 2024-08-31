package com.htckymk.issue_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "project_code", length = 30)
    private String projectCode;
    @Column(name = "project_name", length = 300)
    private String projectName;
    @JoinColumn(name="manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    private User manager;
}
