package ru.croc.ip;

import ru.croc.ip.graphics.GraphicApp;
import ru.croc.ip.service.Sentence;
import ru.croc.ip.service.SentenceManipulator;
import ru.croc.ip.support.DataContainerImplementation;

import java.util.List;

public class Ip {

    public static void main(String[] args) {

        DataContainerImplementation dataContainer = new DataContainerImplementation(true);
        List<Sentence> sentenceList = dataContainer.getData();

        GraphicApp app = new GraphicApp();
        int difficulty = app.parseDifficulty(args[0]);

        SentenceManipulator sentenceManipulator = new SentenceManipulator(sentenceList);
        List<String> processedList = sentenceManipulator.setDifficulty(difficulty);

        app.handler(processedList);

        app.printString(" ");
        app.printString("Вы решили это упражнение на " + sentenceManipulator.getSuccess(app.getRightAnswers()) + " процентов");

    }

}