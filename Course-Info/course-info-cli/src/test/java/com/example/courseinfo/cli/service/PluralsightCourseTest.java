package com.example.courseinfo.cli.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PluralsightCourseTest {

    @Test
    void durationInMin() {
        PluralsightCourse course = new PluralsightCourse("id", "TestCourse", "00:05:33", "url", false);
        assertEquals(5, course.durationInMin());
    }

    @Test
    void durationInMinOverHour() {
        PluralsightCourse course = new PluralsightCourse("id", "TestCourse", "01:05:33", "url", false);
        assertEquals(65, course.durationInMin());
    }

    @Test
    void durationInMinZero() {
        PluralsightCourse course = new PluralsightCourse("id", "TestCourse", "00:00:00", "url", false);
        assertEquals(0, course.durationInMin());
    }
}