package by.andruhovich.test;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionQuadrangleTest {
    private Quadrangle firstQuadrangle;
    private Quadrangle secondQuadrangle;
    private Quadrangle thirdQuadrangle;
    private ActionQuadrangle actionQuadrangle;

    private double[] firstQuadrangleSides;
    private double[] secondQuadrangleSides;
    private double[] thirdQuadrangleSides;

    @BeforeSuite
    public void fieldsInitialization() {
        /*firstQuadrangle= new Quadrangle();
        secondQuadrangle = new Quadrangle();
        thirdQuadrangle = new Quadrangle();
        actionQuadrangle = new ActionQuadrangle();

        double[] firstQuadrangleSides = {3, 5, 2, 7 };
        double[] secondQuadrangleSides = {4.6, 2.3, 6.2, 5.3};
        double[] thirdQuadrangleSides = {1.2, 4.3, 8, 5.7};*/
    }

    @Test
    public void testCalculateSides() {
        Assert.assertEquals(firstQuadrangleSides, actionQuadrangle.calculateSides(firstQuadrangle));
    }
}
