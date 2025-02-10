//5. AI-Driven Resume Screening System
//Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
//Problem Statement:
//Develop an AI-Driven Resume Screening System that can process resumes for different job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
//        Hints:
//Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
//Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
//Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the screening pipeline.


package org.example.Day01;

import java.util.*;

abstract class JobRole {
    String candidateName;
    int experienceYears;
    String skills;

    public JobRole(String candidateName, int experienceYears, String skills) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.skills = skills;
    }

    abstract void displayResume();
}

class SoftwareEngineer extends JobRole {
    String programmingLanguages;

    public SoftwareEngineer(String candidateName, int experienceYears, String skills, String programmingLanguages) {
        super(candidateName, experienceYears, skills);
        this.programmingLanguages = programmingLanguages;
    }

    public void displayResume() {
        System.out.println("Software Engineer: " + candidateName + " | Experience: " + experienceYears +
                " years | Skills: " + skills + " | Languages: " + programmingLanguages);
    }
}

class DataScientist extends JobRole {
    String tools;

    public DataScientist(String candidateName, int experienceYears, String skills, String tools) {
        super(candidateName, experienceYears, skills);
        this.tools = tools;
    }

    public void displayResume() {
        System.out.println("Data Scientist: " + candidateName + " | Experience: " + experienceYears +
                " years | Skills: " + skills + " | Tools: " + tools);
    }
}

class ProductManager extends JobRole {
    String methodologies;

    public ProductManager(String candidateName, int experienceYears, String skills, String methodologies) {
        super(candidateName, experienceYears, skills);
        this.methodologies = methodologies;
    }

    public void displayResume() {
        System.out.println("Product Manager: " + candidateName + " | Experience: " + experienceYears +
                " years | Skills: " + skills + " | Methodologies: " + methodologies);
    }
}

class Resume<T extends JobRole> {
    List<T> resumes;

    public Resume() {
        this.resumes = new ArrayList<>();
    }

    public void addResume(T resume) {
        resumes.add(resume);
        System.out.println("Resume Added: " + resume.candidateName);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

class ResumeScreening {
    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("\nAI-Driven Resume Screening:");
        for (JobRole resume : resumes) {
            resume.displayResume();
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        Resume<ProductManager> productManagerResumes = new Resume<>();

        SoftwareEngineer se1 = new SoftwareEngineer("Alice", 5, "Java, Spring Boot", "Java, Python");
        SoftwareEngineer se2 = new SoftwareEngineer("Bob", 3, "React, Node.js", "JavaScript, TypeScript");
        softwareEngineerResumes.addResume(se1);
        softwareEngineerResumes.addResume(se2);

        DataScientist ds1 = new DataScientist("Charlie", 4, "Machine Learning, Deep Learning", "TensorFlow, Pandas");
        DataScientist ds2 = new DataScientist("David", 2, "Data Visualization, SQL", "Tableau, SQL");
        dataScientistResumes.addResume(ds1);
        dataScientistResumes.addResume(ds2);

        ProductManager pm1 = new ProductManager("Eve", 6, "Agile, Scrum", "Lean, Kanban");
        ProductManager pm2 = new ProductManager("Frank", 3, "User Research, A/B Testing", "OKRs, Roadmaps");
        productManagerResumes.addResume(pm1);
        productManagerResumes.addResume(pm2);

        ResumeScreening.processResumes(softwareEngineerResumes.getResumes());
        ResumeScreening.processResumes(dataScientistResumes.getResumes());
        ResumeScreening.processResumes(productManagerResumes.getResumes());
    }
}
