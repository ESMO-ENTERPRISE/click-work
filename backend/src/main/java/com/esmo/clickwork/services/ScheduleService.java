package com.esmo.clickwork.services;

import com.esmo.clickwork.entities.Schedule;
import com.esmo.clickwork.entities.User;
import com.esmo.clickwork.enums.ScheduleStatusEnum;
import com.esmo.clickwork.exceptions.ResourceNotFoundException;
import com.esmo.clickwork.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public List<Schedule> findByUserId(String userId) {
        User user = userService.findById(userId);

        return scheduleRepository.findByUser(user);
    }

    public List<Schedule> findByUserIdAndDate(String userId, Date date) {
        User user = userService.findById(userId);

        return scheduleRepository.findByUserAndEntryTime(user, date);
    }

    public List<Schedule> findByUserEmail(String userEmail) {
        User user = userService.findByEmail(userEmail);

        return scheduleRepository.findByUser(user);
    }

    public Schedule findById(String id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Schedule", "id", id));
    }

    public Schedule save(Schedule schedule) {
        User user = userService.findById(schedule.getUser().getId());

        schedule.setUser(user);

        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule) {
        Schedule scheduleToUpdate = findById(schedule.getId());

        if (schedule.getExitTime() != null) {
            scheduleToUpdate.setExitTime(schedule.getEntryTime());
            long diff = schedule.getEntryTime().getTime() - schedule.getExitTime().getTime();
            Duration duration = Duration.ofMillis(diff);
            long HH = duration.toHours();
            long MM = duration.toMinutesPart();
            long SS = duration.toSecondsPart();

            schedule.setDuration(HH + ":" + MM + ":" + SS);
            schedule.setStatus(ScheduleStatusEnum.FINISHED);
        }

        scheduleToUpdate.setNotes(schedule.getNotes());

        return scheduleRepository.save(scheduleToUpdate);
    }

    public boolean delete(String id) {
        Schedule schedule = findById(id);
        scheduleRepository.delete(schedule);

        return true;
    }
}
