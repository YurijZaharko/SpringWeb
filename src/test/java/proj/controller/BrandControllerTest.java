package proj.controller;

import org.junit.Assert;
import org.junit.Test;
import proj.entity.Brand;

/**
 * Created by SC on 17.07.2017.
 */
class BrandControllerTest {

    @Test
    void getBrand() {
        Assert.assertNotNull(new Brand());
    }

}