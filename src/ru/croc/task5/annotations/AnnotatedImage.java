package ru.croc.task5.annotations;

import java.util.Arrays;

public class AnnotatedImage {
    private final String imagePath;
    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for(int i = 0; i < annotations.length; i++) {
            if(annotations[i].getFigure().contains(x, y)) {
                return annotations[i];
            }
        }
        System.out.println("Совпадений не найдено!");
        return null;
    }

    public Annotation findByLabel(String label) {
        for(int i = 0; i < annotations.length; i++) {
            if(annotations[i].getSigns().contains(label)) {
                return annotations[i];
            }
        }
        System.out.println("Совпадений не найдено!");
        return null;
    }

    public String toString() {
        return "Путь к картинке: " + imagePath + "\nАннотации: " + Arrays.toString(annotations);
    }


}
