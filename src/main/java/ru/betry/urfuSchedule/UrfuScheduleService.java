package ru.betry.urfuSchedule;

import java.io.IOException;
import java.util.Date;

public class UrfuScheduleService {
    public static class InvalidGroupException extends Exception {
        public InvalidGroupException(String errorMessage) { super(errorMessage); }
    }

    public IUrfuAPI api;
    private final IScheduleParser parser;

    public UrfuScheduleService() {
        api = new UrfuScheduleApi();
        parser = new UrfuScheduleParser();
    }

    /**
     * Принимает на вход группу и дату, возвращает расписание на некоторое кол-во дней вперёд.
     * @param group группа в формате МЕН-хххххх
     * @param date дата
     * @param daysAhead на сколько дней вперёд нужно вернуть расписание
     * @return расписание на неделю, которая включает в себя дату date
     */

    // достаём данные из таблицы
    public String[] getScheduleByGroup(String group, Date date, int daysAhead) throws InvalidGroupException, IOException {
        var schedulePageContent = api.getSchedulePageContent(group, date);

        return parser.extractSchedule(schedulePageContent, daysAhead);
    }
}
