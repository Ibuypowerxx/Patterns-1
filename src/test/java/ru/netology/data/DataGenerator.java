package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {

    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань",
                "Барнаул", "Белгород", "Биробиджан", "Благовещенск", "Брянск",
                "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж",
                "Горно-Алтайск", "Грозный",
                "Екатеринбург",
                "Йошкар-Ола",
                "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл",
                "Липецк",
                "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Мурманск",
                "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск",
                "Омск", "Орёл", "Оренбург",
                "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков",
                "Ростов-на-Дону", "Рязань",
                "Салехард", "Самара", "Санкт-Петербург", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар",
                "Тамбов", "Тверь", "Томск", "Тула", "Тюмень",
                "Улан-Удэ", "Ульяновск", "Уфа",
                "Хабаровск", "Ханты-Мансийск",
                "Чебоксары", "Челябинск", "Черкесск", "Чита",
                "Элиста",
                "Южно-Сахалинск",
                "Якутск", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }
    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }
    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }
    public static class Registration {
        private Registration() {
        }
        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    public static final class UserInfo {
        private final String city;
        private final String name;
        private final String phone;

        public UserInfo(String city, String name, String phone) {
            this.city = city;
            this.name = name;
            this.phone = phone;
        }

        public String getCity() {
            return this.city;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof UserInfo)) return false;
            final UserInfo other = (UserInfo) o;
            final Object this$city = this.getCity();
            final Object other$city = other.getCity();
            if (!Objects.equals(this$city, other$city)) return false;
            final Object this$name = this.getName();
            final Object other$name = other.getName();
            if (!Objects.equals(this$name, other$name)) return false;
            final Object this$phone = this.getPhone();
            final Object other$phone = other.getPhone();
            if (!Objects.equals(this$phone, other$phone)) return false;
            return true;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $city = this.getCity();
            result = result * PRIME + ($city == null ? 43 : $city.hashCode());
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $phone = this.getPhone();
            result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
            return result;
        }

        public String toString() {
            return "DataGenerator.UserInfo(city=" + this.getCity() + ", name=" + this.getName() + ", phone=" + this.getPhone() + ")";
        }
    }
}

