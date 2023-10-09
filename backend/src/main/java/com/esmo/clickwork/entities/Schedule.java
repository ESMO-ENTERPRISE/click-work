package com.esmo.clickwork.entities;

import com.esmo.clickwork.enums.ScheduleStatusEnum;
import com.esmo.clickwork.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "schedules")
public class Schedule extends BaseEntity {

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "exit_time")
    private Date exitTime;

    @Column(name = "duration")
    private String duration;

    @Column(name = "notes")
    private String notes;

    @Enumerated
    private ScheduleStatusEnum status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
}
