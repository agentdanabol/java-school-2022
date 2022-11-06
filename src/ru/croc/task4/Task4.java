package ru.croc.task4;

import ru.croc.task4.annotations.AnnotatedImage;
import ru.croc.task4.annotations.Annotation;
import ru.croc.task4.figures.Circle;
import ru.croc.task4.figures.Figure;
import ru.croc.task4.figures.Rectangle;

public class Task4 {

    public static void main(String[] args) {
        Figure circ1 = new Circle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Annotation annotation1 = new Annotation(circ1, "Tree");

        Figure rect1 = new Rectangle(Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        Annotation annotation2 = new Annotation(rect1, "Car");

        AnnotatedImage img1 = new AnnotatedImage("src/somepicture.png", annotation1, annotation2);

        System.out.println(img1);
    }

}
