package ru.croc.ip;


import ru.croc.ip.graphics.GraphicApp;
import ru.croc.ip.service.Sentence;
import ru.croc.ip.support.DataContainerImplementation;

import java.util.List;

public class Ip {

    public static void main(String[] args) throws InterruptedException {

        DataContainerImplementation dataContainer = new DataContainerImplementation(true);
        List<Sentence> sentenceList = dataContainer.getData();

        GraphicApp app = new GraphicApp();
        app.runApp(sentenceList);

    }

}
