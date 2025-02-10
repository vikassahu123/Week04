//3. Multi-Level University Course Management System
//Concepts: Generic Classes, Wildcards, Bounded Type Parameters
//Problem Statement:
//Develop a university course management system where different departments offer courses with different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
//Hints:
//Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
//Implement a generic class Course<T extends CourseType> to manage different courses.
//Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.

package org.example.Day01;

import java.util.*;

abstract class CourseType {
    String courseName;
    String instructor;
    int duration;

    public CourseType(String courseName, String instructor, int duration) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
    }

    abstract void displayDetails();
}

class ExamCourse extends CourseType {
    int totalMarks;

    public ExamCourse(String courseName, String instructor, int duration, int totalMarks) {
        super(courseName, instructor, duration);
        this.totalMarks = totalMarks;
    }

    public void displayDetails() {
        System.out.println("Exam Course: " + courseName + " | Instructor: " + instructor + " | Duration: " + duration + " weeks | Total Marks: " + totalMarks);
    }
}

class AssignmentCourse extends CourseType {
    int assignmentCount;

    public AssignmentCourse(String courseName, String instructor, int duration, int assignmentCount) {
        super(courseName, instructor, duration);
        this.assignmentCount = assignmentCount;
    }

    public void displayDetails() {
        System.out.println("Assignment Course: " + courseName + " | Instructor: " + instructor + " | Duration: " + duration + " weeks | Assignments: " + assignmentCount);
    }
}

class ResearchCourse extends CourseType {
    String researchArea;

    public ResearchCourse(String courseName, String instructor, int duration, String researchArea) {
        super(courseName, instructor, duration);
        this.researchArea = researchArea;
    }

    public void displayDetails() {
        System.out.println("Research Course: " + courseName + " | Instructor: " + instructor + " | Duration: " + duration + " weeks | Research Area: " + researchArea);
    }
}

class Course<T extends CourseType> {
    List<T> courses;

    public Course() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
        System.out.println("Course Added: " + course.courseName);
    }

    public void removeCourse(T course) {
        courses.remove(course);
        System.out.println("Course Removed: " + course.courseName);
    }

    public List<T> getCourses() {
        return courses;
    }
}

class CourseUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        System.out.println("\nUniversity Course Catalog:");
        for (CourseType course : courses) {
            course.displayDetails();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourseCatalog = new Course<>();
        Course<AssignmentCourse> assignmentCourseCatalog = new Course<>();
        Course<ResearchCourse> researchCourseCatalog = new Course<>();

        ExamCourse math = new ExamCourse("Mathematics", "Dr. Smith", 12, 100);
        ExamCourse physics = new ExamCourse("Physics", "Dr. Johnson", 10, 150);
        examCourseCatalog.addCourse(math);
        examCourseCatalog.addCourse(physics);

        AssignmentCourse java = new AssignmentCourse("Java Programming", "Prof. Williams", 8, 5);
        AssignmentCourse python = new AssignmentCourse("Python Development", "Prof. Brown", 6, 4);
        assignmentCourseCatalog.addCourse(java);
        assignmentCourseCatalog.addCourse(python);

        ResearchCourse ai = new ResearchCourse("Artificial Intelligence", "Dr. Lee", 16, "Machine Learning");
        ResearchCourse bioinformatics = new ResearchCourse("Bioinformatics", "Dr. Miller", 14, "Genomics");
        researchCourseCatalog.addCourse(ai);
        researchCourseCatalog.addCourse(bioinformatics);

        CourseUtils.displayAllCourses(examCourseCatalog.getCourses());
        CourseUtils.displayAllCourses(assignmentCourseCatalog.getCourses());
        CourseUtils.displayAllCourses(researchCourseCatalog.getCourses());
    }
}
