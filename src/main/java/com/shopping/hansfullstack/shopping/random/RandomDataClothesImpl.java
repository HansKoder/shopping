package com.shopping.hansfullstack.shopping.random;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomDataClothesImpl implements RandomDataClothes {

    private List<String> BRANDS_CLOTHES = Arrays.asList("ESSENTIALS", "ARTURO CALLE", "LEVIS");

    private List<String> SIZE_CLOTHES = Arrays.asList("XL", "S", "M");

    private List<String> CATEGORY_CLOTHES = Arrays.asList("Pants", "T-shirts", "Jackets");

    private List<String> COLORS = Arrays.asList("White", "Blue", "Black", "Brown", "Pink");

    @Override
    public Clothes getRandomClothes () {
        String brand = getRandomOfList(BRANDS_CLOTHES);
        String category = getRandomOfList(CATEGORY_CLOTHES);
        String size = getRandomOfList(SIZE_CLOTHES);
        String color = getRandomOfList(COLORS);
        String name = category + " - " + color + " - " + generateWord();

        return Clothes.builder()
                .brand(brand)
                .category(category)
                .detail_size(size)
                .name(name)
                .build();
    }

    private String getRandomOfList (List<?> list) {
        Random random = new Random();

        int index = random.nextInt(0, list.size());

        return list.get(index).toString();
    }

    private String generateWord () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return  generatedString;
    }
}
