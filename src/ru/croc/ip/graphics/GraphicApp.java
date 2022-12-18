package ru.croc.ip.graphics;

import ru.croc.ip.service.WordsManipulator;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GraphicApp {

    private final JPanel panel;
    private String message;
    private int rightAnswers;
    private WordsManipulator wordsManipulator;

    AtomicBoolean state = new AtomicBoolean(false);

    public GraphicApp() {

        JFrame frame = new JFrame("LanguageSchool");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

        panel = new JPanel(new VerticalLayout());
        panel.setBounds(40,40,400,400);

        printString("Тест: составьте предложение из заданных слов");
        printString(" ");
        frame.setContentPane(panel);

        rightAnswers = 0;
    }

    public void handler(List<String> sentenceList) {

        for(String sentence : sentenceList) {

            wordsManipulator = new WordsManipulator(sentence);
            printString(" ");
            printString(wordsManipulator.getMixedSentence());
            createInput();

            System.out.println("check");
            while (state.compareAndSet(false, state.get())) {
                Thread.onSpinWait();
            }

        }

    }

    public void printString(String mixedSentence) {
        JLabel message = new JLabel(mixedSentence);
        panel.add(message);
        panel.revalidate();
    }

    public void createInput() {
        state.set(false);

        JLabel label = new JLabel("Введите правильное предложение: ");
        label.setSize(600,20);
        panel.add(label);

        JTextField input = new JTextField(10);
        input.setSize(600,40);
        panel.add(input);

        JButton submit = new JButton("Проверить");
        submit.setSize(85,20);
        panel.add(submit);

        panel.revalidate();

        submit.addActionListener(e -> {
            message = input.getText();
            panel.remove(submit);
            panel.remove(input);
            panel.remove(label);
            readMessage();
        });
    }

    public void readMessage() {
        if(wordsManipulator.checkSentence(message)){
            printString("Ответ правильный!");
            rightAnswers++;
        }
        else {
            printString("Ответ неправильный!");
            printString("Правильное предложение: "  + wordsManipulator.getSourceSentence());
        }
        state.set(true);
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public int parseDifficulty(String level) {
        switch (level) {
            case "easy" -> {
                return 1;
            }
            case "medium" -> {
                return 2;
            }
            case "hard" -> {
                return 3;
            }
            default -> {
                try {
                    throw new Exception("Wrong difficulty level!");
                } catch (Exception e) {
                    throw  new RuntimeException(e);
                }
            }
        }
    }

}
