package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void SortTicketsByPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 20_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Москва", "Пафос");
        Ticket[] expected = {ticket4, ticket8, ticket5, ticket7, ticket2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortByPriceNoRequired() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 19_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Москва", "Лондон");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortTicketsByPriceOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 19_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("Тюмень", "Стамбул");
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortByFlightTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 19_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comporator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("Москва", "Пафос", comporator);
        Ticket[] expected = {ticket7, ticket2, ticket8, ticket5, ticket4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortByFlightTimeNoTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 19_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comporator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("Москва", "Екатеринбург", comporator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortByFlightTimeOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "Москва", 14_200, 2, 19);
        Ticket ticket2 = new Ticket("Москва", "Пафос", 27_400, 18, 23);
        Ticket ticket3 = new Ticket("Пафос", "Москва", 21_100, 9, 13);
        Ticket ticket4 = new Ticket("Москва", "Пафос", 19_800, 11, 18);
        Ticket ticket5 = new Ticket("Москва", "Пафос", 20_900, 16, 22);
        Ticket ticket6 = new Ticket("Тюмень", "Стамбул", 18_000, 16, 20);
        Ticket ticket7 = new Ticket("Москва", "Пафос", 22_000, 7, 11);
        Ticket ticket8 = new Ticket("Москва", "Пафос", 20_800, 19, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comporator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("Пафос", "Москва", comporator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);

    }


}
