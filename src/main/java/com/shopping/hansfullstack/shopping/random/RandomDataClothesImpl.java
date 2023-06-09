package com.shopping.hansfullstack.shopping.random;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.entities.Supplier;
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

        String img = "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGFudHN8ZW58MHx8MHx8fDA%3D&w=1000&q=80";

        return Clothes.builder()
                .brand(brand)
                .category(category)
                .detailSize(size)
                .name(name)
                .img(img)
                .build();
    }

    @Override
    public Supplier getRandomSupplier() {
        return Supplier.builder()
                .name(generateWord())
                .nit(generateWord())
                .email(generateEmail())
                .phone(generatePhoneNumber())
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

    private String generateWord (int limit) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = limit;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return  generatedString;
    }

    private String generateEmail () {
        return generateWord(8) + "@" + generateWord(3) + ".com";
    }

    private String generatePhoneNumber () {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 57; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return  "35+" + generatedString;
    }


}
