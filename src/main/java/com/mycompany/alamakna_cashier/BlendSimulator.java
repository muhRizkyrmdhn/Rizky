package com.mycompany.alamakna_cashier;

public class BlendSimulator {

    // Polymorphism
    public double hitungProfilRasaSCAA(int rasioArabika) {
        // standar SCAA untuk Flavor Score
        return (rasioArabika * 0.85) + ((100 - rasioArabika) * 0.65);
    }

    // Polymorphism
    public double hitungProfilRasaSCAA(int rasioArabika, double roastFactor) {
        return ((rasioArabika * 0.85) + ((100 - rasioArabika) * 0.65)) * roastFactor;
    }
}
