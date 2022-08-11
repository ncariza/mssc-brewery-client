package com.ncariza.msscbreweryclient.web.client;

import com.ncariza.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Root Beer").build();

        URI uri = breweryClient.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println("Created new beer URI = " + uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Root Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);

    }

    @Test
    void testDeleteBeer(){
        UUID beerId = UUID.randomUUID();
        BeerDto beerDto = BeerDto.builder().id(beerId).beerName("Root Beer").build();

        BeerDto checkBeer = breweryClient.getBeerById(beerId);
        assertNotNull(checkBeer);

        breweryClient.deleteBeer(beerId);
        /*
        BeerDto deletedBeer = breweryClient.getBeerById(beerId);
        assertNull(deletedBeer);
        */
    }
}