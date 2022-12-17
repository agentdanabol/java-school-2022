package ru.croc.ip.support;

import ru.croc.ip.service.Sentence;

import java.util.List;

public interface DataContainer {

    void fulfillData();

    <T> T getData();

}
