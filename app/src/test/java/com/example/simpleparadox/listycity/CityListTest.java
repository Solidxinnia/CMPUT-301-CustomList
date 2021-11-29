package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import android.util.Log;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());

        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());

        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testDeleteCities()
    {
        CityList cityList2 = mockCityList();

        assertEquals(1, cityList2.getCities().size());

        City city = new City("Edmonton", "Alberta");
        City city2 = new City("Regina", "Saskatchewan");
        //String s = city.getProvinceName();
        //Log.d("ki",s);
        cityList2.add(city2);
        cityList2.delete(city2);

        assertEquals(1, cityList2.getCities().size());
        assertTrue(!cityList2.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }



    @Test
    void testSize()
    {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        City city1 = new City("Toronto", "Prince Edward Island");
        cityList.add(city1);
        City city2 = new City("Ottawa", "Prince Edward Island");
        cityList.add(city2);
        City city3 = new City("Quebec", "Prince Edward Island");
        cityList.add(city3);
        int x = cityList.size();
        assertEquals(5, x);


    }

}