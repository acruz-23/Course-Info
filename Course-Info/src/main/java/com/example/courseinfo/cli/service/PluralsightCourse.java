package com.example.courseinfo.cli.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PluralsightCourse(String id, String title, String Duration, String contentUrl, boolean isRetired) {

}
