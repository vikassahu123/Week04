//4. Personalized Meal Plan Generator
//Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
//Problem Statement:
//Design a Personalized Meal Plan Generator where users can choose different meal categories like Vegetarian, Vegan, Keto, or High-Protein. The system should ensure only valid meal plans are generated.
//Hints:
//Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
//Implement a generic class Meal<T extends MealPlan> to handle different meal plans.
//Use a generic method to validate and generate a personalized meal plan dynamically.


package org.example.Day01;

import java.util.*;

interface MealPlan {
    void displayMeal();
}

class VegetarianMeal implements MealPlan {
    String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + mealName);
    }
}

class VeganMeal implements MealPlan {
    String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    public void displayMeal() {
        System.out.println("Vegan Meal: " + mealName);
    }
}

class KetoMeal implements MealPlan {
    String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    public void displayMeal() {
        System.out.println("Keto Meal: " + mealName);
    }
}

class HighProteinMeal implements MealPlan {
    String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    public void displayMeal() {
        System.out.println("High-Protein Meal: " + mealName);
    }
}

class Meal<T extends MealPlan> {
    List<T> meals;

    public Meal() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(T meal) {
        meals.add(meal);
        System.out.println("Meal Added: " + meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealUtils {
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        System.out.println("\nPersonalized Meal Plan:");
        for (T meal : meals) {
            meal.displayMeal();
        }
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>();
        Meal<VeganMeal> veganMealPlan = new Meal<>();
        Meal<KetoMeal> ketoMealPlan = new Meal<>();
        Meal<HighProteinMeal> highProteinMealPlan = new Meal<>();

        VegetarianMeal veg1 = new VegetarianMeal("Grilled Veggie Sandwich");
        VegetarianMeal veg2 = new VegetarianMeal("Paneer Salad");
        vegetarianMealPlan.addMeal(veg1);
        vegetarianMealPlan.addMeal(veg2);

        VeganMeal vegan1 = new VeganMeal("Tofu Stir-Fry");
        VeganMeal vegan2 = new VeganMeal("Vegan Burrito");
        veganMealPlan.addMeal(vegan1);
        veganMealPlan.addMeal(vegan2);

        KetoMeal keto1 = new KetoMeal("Grilled Chicken with Avocado");
        KetoMeal keto2 = new KetoMeal("Keto Egg Muffins");
        ketoMealPlan.addMeal(keto1);
        ketoMealPlan.addMeal(keto2);

        HighProteinMeal protein1 = new HighProteinMeal("Salmon with Quinoa");
        HighProteinMeal protein2 = new HighProteinMeal("Egg White Omelette");
        highProteinMealPlan.addMeal(protein1);
        highProteinMealPlan.addMeal(protein2);

        MealUtils.generateMealPlan(vegetarianMealPlan.getMeals());
        MealUtils.generateMealPlan(veganMealPlan.getMeals());
        MealUtils.generateMealPlan(ketoMealPlan.getMeals());
        MealUtils.generateMealPlan(highProteinMealPlan.getMeals());
    }
}

