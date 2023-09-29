package com.example.courseinfo.cli;

import com.example.courseinfo.cli.service.CourseRetrivalService;
import com.example.courseinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String... args){

        LOG.info("CourseRetriever Starting");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as the first argument");
            return;
        }
        try {
            retrieveCourses(args[0]);
//            PluralsightCourse course = new PluralsightCourse("id", "title", "0:54:57", "https://url", false);
//            LOG.info("Course: {}", course);
        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrivalService courseRetrivalService = new CourseRetrivalService();

        List<PluralsightCourse> coursesToStore = courseRetrivalService.getCoursesFor(authorId)
                .stream()
                .filter(not(PluralsightCourse::isRetired))
                .toList();
        LOG.info("Retrieved the following {} courses {}", coursesToStore.size(), coursesToStore);
    }
}
