package ru.betry;

import ru.betry.urfuSchedule.UrfuScheduleService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        TelegramBotProject myTelegramBot = new TelegramBotProject();
//        myTelegramBot.run();

        try {
            var group = "���-200208";
            var date = new Date();

            var schedule = UrfuScheduleService.getScheduleByGroup("���-200208", date, 4);
            for (var day: schedule) {
                System.out.println(day);
                System.out.println();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
