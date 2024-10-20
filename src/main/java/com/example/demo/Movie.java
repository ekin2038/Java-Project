package com.example.demo;

import java.io.Serializable;

public class Movie implements Serializable {
    private String Name;
    private int ReleaseYear;
    private String Genre1;
    private String Genre2;
    private String Genre3;
    private int RunningTime;
    private String ProductionCompany;
    private long Budget;
    private long Revenue;

    public Movie() {

    }
    public void setProductionCompany(String name){
        ProductionCompany= name;
    }

    public long getBudget() {
        return Budget;
    }

    public long getRevenue() {
        return Revenue;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public String getName() {
        return Name;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }


    public Movie(String[] o) {
        Name = o[0];
        ReleaseYear = Integer.parseInt(o[1]);
        Genre1 = o[2];
        Genre2 = o[3];
        Genre3 = o[4];
        RunningTime = Integer.parseInt(o[5]);
        ProductionCompany = o[6];
        Budget = Long.parseLong(o[7]);
        Revenue = Long.parseLong(o[8]);
    }

    public Movie(String str1, int year, String genre1, String genre2, String genre3, int time, String str2, long budget, long revenue) {
        Name = str1;
        ReleaseYear = year;
        Genre1 = genre1;
        Genre2 = genre2;
        Genre3 = genre3;
        RunningTime = time;
        ProductionCompany = str2;
        Budget = budget;
        Revenue = revenue;
    }
}