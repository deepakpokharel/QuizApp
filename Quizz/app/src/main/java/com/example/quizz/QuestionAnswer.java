package com.example.quizz;

public class QuestionAnswer {

    public static String[] getQuestions(String level) {
        switch (level) {
            case "easy":
                return new String[] {
                        "What is 2 + 2?", // Question 1
                        "What color is the sky?", // Question 2
                        "Which animal barks?", // Question 3
                        "What is the opposite of hot?", // Question 4
                        "What shape is a basketball?" // Question 5
                };
            case "medium":
                return new String[] {
                        "What is the capital of Canada?", // Question 1
                        "Which gas do plants absorb?", // Question 2
                        "Who painted the Mona Lisa?", // Question 3
                        "What is the largest continent?", // Question 4
                        "Which planet is known as the Red Planet?" // Question 5
                };
            case "hard":
                return new String[] {
                        "What is the derivative of sin(x)?", // Question 1
                        "Who developed general relativity?", // Question 2
                        "Which element has the atomic number 79?", // Question 3
                        "What is the integral of cos(x)?", // Question 4
                        "Who formulated the laws of motion?" // Question 5
                };
            default:
                return new String[]{};
        }
    }

    public static String[][] getChoices(String level) {
        switch (level) {
            case "easy":
                return new String[][]{
                        {"3", "4", "5", "6"}, // Choices for Question 1
                        {"Blue", "Red", "Green", "Yellow"}, // Choices for Question 2
                        {"Cat", "Dog", "Bird", "Fish"}, // Choices for Question 3
                        {"Cold", "Hot", "Warm", "None"}, // Choices for Question 4
                        {"Circle", "Square", "Triangle", "Oval"} // Choices for Question 5
                };
            case "medium":
                return new String[][]{
                        {"Toronto", "Ottawa", "Vancouver", "Montreal"}, // Choices for Question 1
                        {"Oxygen", "Hydrogen", "Carbon Dioxide", "Nitrogen"}, // Choices for Question 2
                        {"Van Gogh", "Da Vinci", "Picasso", "Rembrandt"}, // Choices for Question 3
                        {"Asia", "Africa", "North America", "Australia"}, // Choices for Question 4
                        {"Mars", "Earth", "Venus", "Saturn"} // Choices for Question 5
                };
            case "hard":
                return new String[][]{
                        {"cos(x)", "-cos(x)", "sin(x)", "-sin(x)"}, // Choices for Question 1
                        {"Isaac Newton", "Albert Einstein", "Niels Bohr", "Marie Curie"}, // Choices for Question 2
                        {"Silver", "Gold", "Platinum", "Iron"}, // Choices for Question 3
                        {"sin(x)", "cos(x)", "tan(x)", "sec(x)"}, // Choices for Question 4
                        {"Galileo", "Newton", "Einstein", "Faraday"} // Choices for Question 5
                };
            default:
                return new String[][]{};
        }
    }

    public static String[] getCorrectAnswers(String level) {
        switch (level) {
            case "easy":
                return new String[]{"4", "Blue", "Dog", "Cold", "Circle"}; // Correct Answers for Easy
            case "medium":
                return new String[]{"Ottawa", "Carbon Dioxide", "Da Vinci", "Asia", "Mars"}; // Correct Answers for Medium
            case "hard":
                return new String[]{"cos(x)", "Albert Einstein", "Gold", "sin(x)", "Newton"}; // Correct Answers for Hard
            default:
                return new String[]{};
        }
    }
}
