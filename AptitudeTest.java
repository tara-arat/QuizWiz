package Placements;
import java.util.Scanner;

abstract class Question {
    private String questionText;
    private String[] options;
    protected String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('a' + i) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }

    public abstract int calculateScore(String userAnswer);
}

class NumericalQuestion extends Question {
    public NumericalQuestion(String questionText, String[] options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public int calculateScore(String userAnswer) {
        if (checkAnswer(userAnswer)) {
            return 4;
        } else {
            return -1;
        }
    }
}

class VerbalQuestion extends Question {
    public VerbalQuestion(String questionText, String[] options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public int calculateScore(String userAnswer) {
        if (checkAnswer(userAnswer)) {
            return 4;
        } else {
            return -1;
        }
    }
}

class LogicalQuestion extends Question {
    public LogicalQuestion(String questionText, String[] options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public int calculateScore(String userAnswer) {
        if (checkAnswer(userAnswer)) {
            return 4;
        } else {
            return -1;
        }
    }
}

public class AptitudeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("********************************************************");
        System.out.println("APTITUDE & LOGICAL REASONING TEST FOR PLACEMENT TRAINING");
        System.out.println("********************************************************");

        Question[] questions = new Question[14]; // 14 questions
        questions[0] = new NumericalQuestion("Category: Time Speed Distance\nRana covers the distance from his home to his office at a speed of 25 km/hr and comes back at a speed of 4 km/hr. He completes the whole journey within 5 hours 48 minutes. Find out the distance from his home to the office.", new String[]{"a. 20 km", "b. 25 km", "c. 18 km", "d. 24 km"}, "a");
        questions[1] = new NumericalQuestion("Category: Ratio and Proportion\nPresent age of Vinod and Ashok is in the ratio of 3:4, respectively. After 5 years, the ratio of their ages becomes 7:9, respectively. What is Ashok’s present age?", new String[]{"a. 28 yrs", "b. 32 yrs", "c. 40 yrs", "d. 45 yrs"}, "c");
        questions[2] = new NumericalQuestion("Category: Profit and loss\nPeter buys a bag at the price of Rs 27.50. After some days, he sells it at the price of Rs 28.90. What is the percentage of his gain?", new String[]{"a. 4%", "b. 5%", "c. 6%", "d. 7%"}, "b");
        questions[3] = new NumericalQuestion("Category: Coding and Decoding\nToday is Monday. After 68 days, it will be:", new String[]{"a. Monday", "b. Tuesday", "c. Wednesday", "d. Sunday"}, "c");
        questions[4] = new NumericalQuestion("Category: Time and Work\nA can finish a piece of work in 20 days, B in 15 days, and C in 12 days. A and B start the work together, and A leaves after 5 days. How many days does B need to complete the remaining work?", new String[]{"a. 5", "b. 6", "c. 7", "d. 8"}, "d");
        questions[5] = new VerbalQuestion("Category: Verbal Reasoning\nSub-Category: Verbal Analogies\n1. LIGHT:BLIND", new String[]{"a. speech:dumb", "b. language:deaf", "c. tongue:sound", "d. voice:vibration"}, "b");
        questions[6] = new VerbalQuestion("Sub-Category: Word Relationships\n2. FRIEND:LOYAL", new String[]{"a. student:studious", "b. teacher:class", "c. worker:lazy", "d. master:servant"}, "a");
        questions[7] = new VerbalQuestion("Sub-Category: Letter Series\n3. Complete the series: A, E, I, M, Q, ?", new String[]{"a. T", "b. U", "c. V", "d. W"}, "c");
        questions[8] = new VerbalQuestion("Sub-Category: Verbal Analogies\n4. CAT:FELINE", new String[]{"a. dog:canine", "b. lion:jungle", "c. fish:aquatic", "d. bird:fly"}, "a");
        questions[9] = new VerbalQuestion("Sub-Category: Word Relationships\n5. ARID:DESERT", new String[]{"a. icy:polar", "b. snowy:winter", "c. rainy:forest", "d. humid:swamp"}, "c");
        questions[10] = new LogicalQuestion("Sub-Category: Order and Ranking\nSampratha is 9th from the left side of the row, and Supreetha is 22nd from the right side of the row.\nFind the number of dancers standing between the sisters Sampratha and Supreetha?", new String[]{"A. 4", "B. 5", "C. 6", "D. 7"}, "B");
        questions[11] = new LogicalQuestion("Sub-Category: Order and Ranking\nAncient history is 25th from the left side of the row, and Middivel history is 30th from the right side of the row.\nWhat is the total number of books between Ancient and Middivel history?", new String[]{"A. 6", "B. 7", "C. 8", "D. 9"}, "C");
        questions[12] = new LogicalQuestion("Sub-Category: Clock\nHow many times do the hands of a clock coincide in a day?", new String[]{"A. 20", "B. 21", "C. 22", "D. 24"}, "C");
        questions[13] = new LogicalQuestion("Sub-Category: Blood Relations\nA is the brother of B. B is the sister of C. How is C related to A?", new String[]{"A. Son", "B. Daughter", "C. Niece", "D. Nephew"}, "C");

        // Display and handle questions (Limit to 14 questions)
        for (int i = 0; i < 14; i++) {
            System.out.println("Question " + (i + 1) + ":");
            questions[i].displayQuestion();

            System.out.print("Your answer (a/b/c/d): ");
            String userAnswer = scanner.next().toLowerCase();

            int score = questions[i].calculateScore(userAnswer);
            if (score == 4) {
                System.out.println("Correct! You scored 4 points.\n");
                totalScore += 4;
            } else if (score == -1) {
                System.out.println("Incorrect. The correct answer is: " + questions[i].correctAnswer + "\n");
            }
        }

        System.out.println("*************************************");
        System.out.println("Test completed. Your Total Score: " + totalScore + "/56");
        System.out.println("*************************************");

        // Close the scanner
        scanner.close();
    }
}