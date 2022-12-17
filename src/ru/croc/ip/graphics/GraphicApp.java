package ru.croc.ip.graphics;

import ru.croc.ip.service.Sentence;
import ru.croc.ip.service.SentenceManipulator;
import ru.croc.ip.service.WordsManipulator;

import javax.swing.*;
import java.awt.*;
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
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

        panel = new JPanel(new VerticalLayout());
        panel.setBounds(40,40,600,600);

        printString("Тест: составьте предложение из заданных слов");
        printString(" ");
        frame.setContentPane(panel);

        rightAnswers = 0;
    }

    public void runApp(List<Sentence> sentenceList) {

        panel.add(new JLabel("Выберите сложность!"));

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton easyButton = new JButton("Easy");
        buttonPanel.add(easyButton);

        JButton mediumButton = new JButton("Medium");
        buttonPanel.add(mediumButton);

        JButton hardButton = new JButton("Hard");
        buttonPanel.add(hardButton);

        panel.add(buttonPanel);
        panel.revalidate();

        easyButton.addActionListener(e -> {
            panel.remove(buttonPanel);
            state.set(true);
            //handler(sentenceList, 1);
        });
        mediumButton.addActionListener(e -> {
            panel.remove(buttonPanel);
            state.set(true);
            handler(sentenceList, 2);
        });
        hardButton.addActionListener(e -> {
            panel.remove(buttonPanel);
            state.set(true);
            handler(sentenceList, 3);
        });

    }

    public void handler(List<Sentence> sentenceList, int difficultyLevel) {

        SentenceManipulator sentenceManipulator = new SentenceManipulator(sentenceList);
        List<String> processedList = sentenceManipulator.setDifficulty(difficultyLevel);

        for(String sentence : processedList) {
            wordsManipulator = new WordsManipulator(sentence);
            printString(" ");
            printString(wordsManipulator.getMixedSentence());
            createInput();

            System.out.println("check");
            while (state.compareAndSet(false, state.get())) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        printString(" ");
        printString("Вы решили это упражнение на " + sentenceManipulator.getSuccess(getRightAnswers()) + " процентов");
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

}
