package ru.croc.Task5;

import ru.croc.Task5.annotations.AnnotatedImage;
import ru.croc.Task5.annotations.Annotation;
import ru.croc.Task5.figures.Circle;
import ru.croc.Task5.figures.Figure;
import ru.croc.Task5.figures.Movable;
import ru.croc.Task5.figures.Rectangle;

public class Task5 {

    public static void main(String[] args) {
        Figure circ1 = new Circle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Annotation annotation1 = new Annotation(circ1, "Tree");

        Figure rect1 = new Rectangle(Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        Annotation annotation2 = new Annotation(rect1, "Car");

        AnnotatedImage img1 = new AnnotatedImage("src/somepicture.png", annotation1, annotation2);

        System.out.println("Путь к картинке: " + img1.getImagePath());
        System.out.println("Аннотации: ");
        for(int i = 0; i < img1.getAnnotations().length; i++) {
            System.out.println(img1.getAnnotations()[i]);
        }
        System.out.println("\n");

        System.out.println("Поиск первого вхождения 'Са': ");
        for(int i = 1; i < img1.getAnnotations().length; i++) {
            System.out.println(img1.findByLabel("Ca") + "\n");
        }

        System.out.println("Поиск первого вхождения '100, 100': ");
        for(int i = 1; i < img1.getAnnotations().length; i++) {
            System.out.println(img1.findByPoint(10, 100) + "\n");
        }

        circ1.move(32, 12);
        System.out.println(circ1);

        rect1.move(-10, 20);
        System.out.println(rect1);
    }

}
