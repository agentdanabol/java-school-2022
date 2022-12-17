package ru.croc.ip.support;

import ru.croc.ip.service.Sentence;

import java.sql.*;
import java.util.*;

public class DataContainerImplementation implements DataContainer {

    private Connection connection;
    private Statement basicStatement;

    public DataContainerImplementation(boolean fill) {
        try {
            this.connection = DriverManager.getConnection("jdbc:h2:mem:~/school", "sa", "");

            basicStatement = connection.createStatement();
            basicStatement.execute("create table sentences (id int primary key auto_increment, sentence varchar, difficulty varchar)");

            if(fill) {
                fulfillData();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fulfillData() {
        try {
            Map<String, List<String>> primaryData = new HashMap<>();

            List<String> primaryWords1 = new ArrayList<>();
            primaryWords1.add("What is your favourite dish?");
            primaryWords1.add("My name is Charles");
            primaryWords1.add("This puppet is very pretty");
            primaryData.put("easy", primaryWords1);

            List<String> primaryWords2 = new ArrayList<>();
            primaryWords2.add("Ted always buys an ice cream on saturdays");
            primaryWords2.add("I am going to visit a library today");
            primaryWords2.add("I made this cupboard on my own");
            primaryData.put("medium", primaryWords2);

            List<String> primaryWords3 = new ArrayList<>();
            primaryWords3.add("If I were you, I would sell these old costumes");
            primaryWords3.add("Have you ever been to the USA?");
            primaryWords3.add("He is very smart, yet he lacks diligence");
            primaryData.put("hard", primaryWords3);

            for(Map.Entry<String, List<String>> entry : primaryData.entrySet()) {
                String level = entry.getKey();
                List<String> primaryList = new ArrayList<>(entry.getValue());

                for(String words : primaryList) {
                    String row = " values ('" + words + "', '" + level + "')";
                    PreparedStatement statement = connection.prepareStatement("select * from sentences where sentence = ?");
                    statement.setString(1, words);
                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        basicStatement.execute("insert into sentences (sentence, difficulty)" + row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Sentence> getData() {
        try {
            List<Sentence> sentenceList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from sentences");
            while(resultSet.next()){
                sentenceList.add(new Sentence(resultSet.getString("sentence"),
                        resultSet.getString("difficulty")));
            }
            return sentenceList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
