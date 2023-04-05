package ru.netology.task1;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Цири")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Цинтра")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Мик")
                .build();
        System.out.println("У " + mom + " есть сын - " + son + " " + son.getSurname());

        System.out.print("У " + mom + " сегодня День рождения!");
        mom.happyBirthday();
        System.out.println(" Ей исполнилось " + mom.getAge().orElseThrow() +
                ". Она празднует в Ривии, где и планирует остаться.");
        mom.setAddress("Ривия");
        System.out.println("Вот уже 2 недели как её дом - " + mom.getAddress());

        System.out.println();
        Person amnesiac = new PersonBuilder()
                .setName("Уилсон")
                .setSurname("Уилсов")
                .build();
        System.out.println(amnesiac + " не знает когда праздновать свой День Рождения =( " +
                "\n[hasAge = " + amnesiac.hasAge() + "]");
        // Т.к. возраст человека не известен, то ничего не произойдёт:
        amnesiac.happyBirthday();
        System.out.println("Так не пойдёт. Он возьмёт за отправную точку - 30 лет с сегодняшенго дня.");
        amnesiac.setAge(30);
        // А вот здесь уже возраст увеличиться, т.к. определён примерный возраст:
        amnesiac.happyBirthday();
        System.out.println("Вот и прошёл год! " + amnesiac + " стал старше и ему уже " + amnesiac.getAge().orElseThrow());
        // В дальнейшем возраст поменять уже не получиться:
        amnesiac.setAge(40);
        System.out.println("Всё еще " + amnesiac.getAge().orElseThrow());

        System.out.println();
        try {
            // Exception: Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Exception: Недопустимый возраст
            new PersonBuilder()
                    .setName("Кир")
                    .setSurname("Лумир")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}