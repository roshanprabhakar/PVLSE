package com.neelk.outsidehacks2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class htmlParser {

    private static final String lineSeparator = System.getProperty("line.separator");
    public static String randArtist, randTitle;
    private static ArrayList<String> artists;
    private static ArrayList<String> titles;





    public static void parseHTMLselectSONG(String html) {
        artists = new ArrayList<String>();
        titles = new ArrayList<String>();

        int count = 0;
        while (!html.equals("")) {

            html = html.substring(html.indexOf("<tr>"));
            html = html.substring(html.indexOf("</td>"));
            html = html.substring(html.indexOf("a href="));
            if (count == 0) {
                html = html.substring(html.indexOf("<a href="));
                html = html.substring(html.indexOf("href="));
            }
//			String artist = html.substring(html.indexOf(">") + 1, html.indexOf("<"));
//			System.out.println(artist);
            artists.add(html.substring(html.indexOf(">") + 1, html.indexOf("<")).replace("\\", ""));
            html = html.substring(html.indexOf("</td>"));
            html = html.substring(html.indexOf("a href="));
            titles.add(html.substring(html.indexOf(">") + 1, html.indexOf("<")).replace("\\", ""));

            if (html.indexOf("<tr>") == -1) {
                html = "";
            }

            count++;
        }

        System.out.println(Math.random() + "     " + artists.size());
        randArtist = artists.get((int) (Math.random() * artists.size()));
        randTitle = titles.get(artists.indexOf(randArtist));
        artists.clear();
        titles.clear();
    }

    public static void randSelection(String inputFilename, String outputFilename) {
        Scanner scan = null;
        FileWriter writer = null;
        BufferedWriter bWriter = null;

        try {

            FileReader reader = new FileReader(inputFilename);
            BufferedReader bReader = new BufferedReader(reader);
            scan = new Scanner(bReader);

            writer = new FileWriter(outputFilename);
            bWriter = new BufferedWriter(writer);

            randArtist = artists.get((int) (Math.random() * artists.size()));
            randTitle = titles.get(artists.indexOf(randArtist));

            bWriter.write(randArtist);
            bWriter.write(lineSeparator);
            bWriter.write(randTitle);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (scan != null)
                scan.close();

            try {
                if (bWriter != null)
                    bWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void extract(String inputFilename, String outputFilename) {
        Scanner scan = null;
        FileWriter writer = null;
        BufferedWriter bWriter = null;
        int count = 0;

        try {

            FileReader reader = new FileReader(inputFilename);
            BufferedReader bReader = new BufferedReader(reader);
            scan = new Scanner(bReader);

            writer = new FileWriter(outputFilename);
            bWriter = new BufferedWriter(writer);

            String completeFile = scan.nextLine();

            while (!completeFile.equals("")) {

//				System.out.println(completeFile.indexOf("<tr>"));
                completeFile = completeFile.substring(completeFile.indexOf("<tr>"));
                completeFile = completeFile.substring(completeFile.indexOf("</td>"));
                completeFile = completeFile.substring(completeFile.indexOf("a href="));
                if (count == 0) {
                    completeFile = completeFile.substring(completeFile.indexOf("<a href="));
                    completeFile = completeFile.substring(completeFile.indexOf("href="));
                }
//				System.out.println((completeFile.indexOf("<")));//, completeFile.indexOf("<")));
                String artist = completeFile.substring(completeFile.indexOf(">") + 1, completeFile.indexOf("<"));
                System.out.println(artist);
                artists.add(completeFile.substring(completeFile.indexOf(">") + 1, completeFile.indexOf("<")).replace("\\", ""));
                completeFile = completeFile.substring(completeFile.indexOf("</td>"));
                completeFile = completeFile.substring(completeFile.indexOf("a href="));
                titles.add(completeFile.substring(completeFile.indexOf(">") + 1, completeFile.indexOf("<")).replace("\\", ""));
//				completeFile = completeFile.substring(completeFile.indexOf("</tr>"));

                if (completeFile.indexOf("<tr>") == -1) {
                    completeFile = "";
                }

                String space = "";
                while (space.length() < 50 - artists.get(count).length()) {
                    space += " ";
                }

                bWriter.write(artists.get(count) + space + titles.get(count));
                bWriter.write(lineSeparator);

                count++;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (scan != null)
                scan.close();

            try {
                if (bWriter != null)
                    bWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
