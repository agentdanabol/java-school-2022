package ru.croc.Task4;

import ru.croc.Task4.annotations.AnnotatedImage;
import ru.croc.Task4.annotations.Annotation;
import ru.croc.Task4.figures.Circle;
import ru.croc.Task4.figures.Figure;
import ru.croc.Task4.figures.Rectangle;

public class Task4 {

    public static void main(String[] args) {
        Figure circ1 = new Circle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Annotation annotation1 = new Annotation(circ1, "Tree");

        Figure rect1 = new Rectangle(Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        Annotation annotation2 = new Annotation(rect1, "Car");

        AnnotatedImage img1 = new AnnotatedImage("src/somepicture.png", annotation1, annotation2);

        System.out.println("Путь к картинке: " + img1.getImagePath());
        System.out.println("Аннотации: \n");
        for(int i = 0; i < img1.getAnnotations().length; i++) {
            System.out.println(img1.getAnnotations()[i]);
        }
    }

}
