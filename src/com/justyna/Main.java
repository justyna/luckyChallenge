package com.justyna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Question {
    private final String question;
    private final Double probabilityThatAnswerIsCorrect;
    private Random lucky = new Random();

    public Question(String question) {
        this.question = question;
        this.probabilityThatAnswerIsCorrect = lucky.nextDouble();
    }

    public Integer getResultAnswer() {
        System.out.println(question);
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String inputString = bufferRead.readLine();
            if(lucky.nextDouble() > probabilityThatAnswerIsCorrect) {
                System.out.println("Twoja odpowiedź : " + inputString + " jest poprawna");
                return 1;
            }
            System.out.println("Twoja odpowiedź : " + inputString + " jest niepoprawna");
            return 0;
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        List<Question> questions = Arrays.asList(new Question("Podaj imie"), new Question("Podaj kolor"), new Question("Podaj kraj"), new Question("Podaj owoc"), new Question("Podaj zwierze"), new Question("Podaj kwiat"));
        System.out.println("Sprawdż czy masz szczęście");
        String feedback = (questions.stream().map(Question::getResultAnswer).reduce(0, (a, b) -> a + b) >= 4 )? "Masz szczęście" : "Nie masz szczęścia";
        System.out.println(feedback);
    }
}
