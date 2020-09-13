package com.raitonbl.fromdocs.services;

import com.raitonbl.fromdocs.Document;
import com.raitonbl.fromdocs.DocumentService;
import com.raitonbl.fromdocs.DocumentServiceChain;
import com.raitonbl.fromdocs.docs.ID;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unchecked"})
public class IDService implements DocumentService {

    @Override
    public <Y extends Document> Y map(String src, Class<Y> returnType, DocumentServiceChain chain) {

        if (src == null || returnType == null) {
            return null;
        }

        if (!returnType.equals(ID.class)) {
            return chain.map(src, returnType);
        }

        String[] array = preProcess(src.split("\\n+"));

        return (Y) ID.Builder.get().setNumber(getNumber(array)).setName(getNames(array) + " " + getLastName(array)).setBirthDate(getBirthDate(array)).build();
    }

    private String getNumber(final String[] data) {

        String firstPart = "", secondPart = "";

        if (data.length > 3) {

            Pattern pattern = Pattern.compile("[0-9]+");

            Matcher matcher = pattern.matcher(data[0]);

            if (matcher.find()) {
                secondPart = matcher.group();
            }

            pattern = Pattern.compile("[0-9]{8}[A-Z]");

            matcher = pattern.matcher(data[2]);

            if (matcher.find()) {
                firstPart = matcher.group();
            }

            char endsWith = firstPart.charAt(8);

            firstPart = firstPart.substring(0, 4);

            return firstPart + secondPart + endsWith;
        }

        return null;
    }

    private String getLastName(final String[] data) {
        return data.length > 3 ? data[3].substring(1) : null;
    }

    private String getNames(final String[] data) {

        StringBuilder builder = new StringBuilder();

        if (data.length > 3) {
            for (int i = 4; i < data.length; i++) {
                if (i != data.length - 1) {
                    builder.append(data[i]).append(" ");
                } else {
                    builder.append(data[i]);
                }
            }
            return builder.toString();
        }

        return null;
    }

    private LocalDate getBirthDate(final String[] data) {

        if (data.length > 2) {
            String line = data[2];
            return LocalDate.of(
                    formatMonthOfYear(Integer.parseInt(line.substring(0, 2))),
                    Integer.parseInt(line.substring(3, 4)),
                    Integer.parseInt(line.substring(5, 6)));
        }

        return null;
    }

    private String[] preProcess(String[] content) {

        int lineStartIndex = 0;

        for (int i = 0; i < content.length; i++) {
            Pattern pattern = Pattern.compile("BIMOZ");

            Matcher matcher = pattern.matcher(content[i]);

            while (matcher.find()) {
                lineStartIndex = i;
                break;
            }

        }

        return (content[lineStartIndex] + content[lineStartIndex + 1] + content[lineStartIndex + 2]).toUpperCase().split("<+");
    }

    private int formatMonthOfYear(int year) {
        return year > 20 ? year + 1900 : year + 2000;
    }

}
