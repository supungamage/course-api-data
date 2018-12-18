package com.springapp.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService { 
	
	@Autowired
	private CourseRepository courseRepository;	
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		System.out.println("getAllCourses 1 .");
		courseRepository.findByTopicId(topicId).forEach(courses :: add);
		System.out.println("getAllCourses 2 ." + courses.size());
		return courses;
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		System.out.println("addCourse 1 .");
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
