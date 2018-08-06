package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    private String[][] workers = {
            {"123", "Adam", "Adamson"},
            {"124", "Bob", "Bobson"},
            {"125", "Charlie", "Charlson"}
    };

    private double[] salaries = {
            4000.00d,
            3500.00d,
            4500.00d
    };

    public String getWorker(int n) {
        if(n >= salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }

}
