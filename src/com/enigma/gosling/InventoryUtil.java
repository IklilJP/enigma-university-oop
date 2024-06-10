package com.enigma.gosling;

public class InventoryUtil {
    private static int counterMagazine = 0;
    private static int counterNovel = 0;


    public static void setCounterMagazine(int counterMagazine) {
        InventoryUtil.counterMagazine = counterMagazine;
    }

    public static void setCounterNovel(int counterNovel) {
        InventoryUtil.counterNovel = counterNovel;
    }

    public static String generateMagazineCode(Magazine magazine) {
        counterMagazine++;
        return String.format("%d-B-%05d", magazine.getYearPublished(), counterMagazine);
    }

    public static String generateNovelCode(Novel novel) {
        counterNovel++;
        return String.format("%d-A-%05d", novel.getYearPublished(), counterNovel);
    }
}
