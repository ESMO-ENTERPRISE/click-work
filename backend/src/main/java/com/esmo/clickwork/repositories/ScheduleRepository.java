package com.esmo.clickwork.repositories;

import com.esmo.clickwork.entities.Schedule;
import com.esmo.clickwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    List<Schedule> findByUser(User user);
    List<Schedule> findByUserAndEntryTime(User user, Date entryTime);
}
