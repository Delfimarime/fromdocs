package com.raitonbl.fromdocs.services;

import com.raitonbl.fromdocs.Document;
import com.raitonbl.fromdocs.DocumentService;
import com.raitonbl.fromdocs.DocumentServiceChain;
import com.raitonbl.fromdocs.docs.NUIT;
import org.apache.commons.lang3.ArrayUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SuppressWarnings({"unchecked"})
public class NuitService implements DocumentService {

    @Override
    public <Y extends Document> Y map(String src, Class<Y> returnType, DocumentServiceChain chain) {

        if (src == null || returnType == null) {
            return null;
        }

        if (!returnType.equals(NUIT.class)) {
            return chain.map(src, returnType);
        }

        String[] array = src.split("\\n+");

        return (Y) NUIT.Builder.get().setNumber(getNumber(array)).setIssuanceDate(getDateIssue(array)).setName(getFullName(array)).build();
    }

    public String getNumber(String[] content) {
        String number = null;

        for (String s : content) {
            if (s.length() <= 10) {

                Pattern pattern = Pattern.compile("[0-9]{9}");
                Matcher matcher = pattern.matcher(s);

                while (matcher.find()) {
                    number = matcher.group();
                    break;
                }

            }
        }

        return number;
    }

    public String getFullName(String[] content) {

        String fullName = null;

        for (String s : content) {
            int result = s.indexOf("Nome:");
            if (result != -1) {
                fullName = s;
                break;
            }
        }

        if (fullName == null) {
            return null;
        }

        return Stream.of(ArrayUtils.remove(fullName.split("\\s+"), 0)).reduce((acc, v) -> acc.isEmpty() ? v : acc + " " + v).orElse(null);
    }

    public LocalDate getDateIssue(String[] content) {

        ArrayList<String> dates = new ArrayList<>();

        for (String s : content) {

            Pattern pattern = Pattern.compile("[0-9]{2}(—|-)[0-9]{2}(—|-)[0-9]{4}");
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                dates.add(matcher.group());
            }

        }

        if (dates.size() > 1) {
            String[] date_array = dates.get(1).split("(—|-)");
            return LocalDate.of(
                    Integer.parseInt(date_array[2]),
                    Integer.parseInt(date_array[1]),
                    Integer.parseInt(date_array[0]));
        }

        return null;
    }

}
