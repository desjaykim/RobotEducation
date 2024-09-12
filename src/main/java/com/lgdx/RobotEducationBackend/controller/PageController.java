package com.lgdx.RobotEducationBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class PageController {

    @GetMapping("/otalk_main")
    public String otalkPage() {
        // otalk_main.html 파일을 반환 (src/main/resources/templates/otalk_main.html에 위치해야 함)
        return "otalk_main";
    }
    @GetMapping("/thinq_main")
    public String thinqMainPage() {
        return "thinq_main";  // thinq_main.html 파일을 반환
    }
    @GetMapping("/counsel")
    public ModelAndView counselRedirect() {
        LocalDateTime now = LocalDateTime.now();  // 현재 시간 가져오기
        DayOfWeek day = now.getDayOfWeek();       // 요일 가져오기
        LocalTime currentTime = now.toLocalTime(); // 현재 시간

        // 평일 시간대 (08:00 ~ 18:00) 체크
        boolean isWeekday = day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY;
        boolean weekdayBusinessHours = isWeekday &&
                (currentTime.isAfter(LocalTime.of(8, 0)) && currentTime.isBefore(LocalTime.of(18, 0)));

        // 주말 시간대 (09:00 ~ 17:00) 체크
        boolean isWeekend = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
        boolean weekendBusinessHours = isWeekend &&
                (currentTime.isAfter(LocalTime.of(9, 0)) && currentTime.isBefore(LocalTime.of(17, 0)));

        // 상담 가능 시간대일 경우 counsel01로 리다이렉트, 아니면 counsel02로 리다이렉트
        if (weekdayBusinessHours || weekendBusinessHours) {
            return new ModelAndView("redirect:/counsel01");
        } else {
            return new ModelAndView("redirect:/counsel02");
        }
    }

    @GetMapping("/counsel01")
    public String counselPage01() {
        return "counsel01";  // counsel01.html 반환
    }

    @GetMapping("/counsel02")
    public String counselPage02() {
        return "counsel02";  // counsel02.html 반환
    }
    @GetMapping("/counsel03")
    public String counselPage03() {
        return "counsel03";  // counsel03.html 반환
    }
    @GetMapping("/counsel05")
    public String counselPage05() {
        return "counsel05";  // counsel05.html 템플릿 반환
    }
    @GetMapping("/counsel07")
    public String counselPage07() {
        return "counsel07";  // counsel07.html 템플릿 반환
    }
    @GetMapping("/recap01")
    public String counselPagelearn01() {
        return "recap01";
    }
    @GetMapping("/recap02")
    public String counselPagelearn02() {
        return "recap02";
    }
    @GetMapping("/recap03")
    public String counselPagelearn03() {
        return "recap03";
    }
    @GetMapping("/recap04")
    public String counselPagelearn04() {
        return "recap04";
    }
    @GetMapping("/recap05")
    public String counselPagelearn05() {
        return "recap05";
    }
    @GetMapping("/counselreview01")
    public String counselPagelearn06() {
        return "counselreview01";
    }
    @GetMapping("/counselreview02")
    public String counselPagelearn07() {
        return "counselreview02";
    }
}


