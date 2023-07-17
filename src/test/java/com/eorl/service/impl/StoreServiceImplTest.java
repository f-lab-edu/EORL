package com.eorl.service.impl;


import com.eorl.domain.store.Store;
import com.eorl.domain.store.StoreStatus;
import com.eorl.repository.StoreRepository;
import java.util.Random;
import org.hibernate.internal.log.SubSystemLogging;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequences;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreServiceImplTest {

    @Autowired
    StoreRepository storeRepository;

    /*@BeforeAll
    void createOne(){
        Store build = Store.builder().storeName("테스트1")
                .location(
                        new Point(
                                new CoordinateArraySequence(
                                        new Coordinate[]{
                                                new Coordinate(123, 456)
                                        }
                                ),
                                new GeometryFactory()
                        ))
                .storeStatus(StoreStatus.ACTIVE)
                .addressMain("서울특별시 영등포구")
                .businessNumber("1234567890")
                .build();

        storeRepository.save(build);
    }*/


    @Test
    void saveStore() {

        //SRID : 4326은 위도-경도 좌표계, 0은 평면 좌표계
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        Random random = new Random();

        Store build = Store.builder().storeName("테스트2")
                .location(
                        geometryFactory.createPoint(new Coordinate(10, 11))
                       )
                .storeStatus(StoreStatus.CLOSED)
                .addressMain("경기도 안양시 만안구")
                .businessNumber("1313131313")
                .build();

        storeRepository.save(build);
    }

    @Test
    void getStoreList() {


    }

    @Test
    void getStore() {
    }

    @Test
    void deleteStore() {
    }

    @Test
    void searchStoreList() {
    }

    @Test
    void update() {
    }
}