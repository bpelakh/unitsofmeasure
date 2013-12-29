/**
 *
 */
package org.unitsofmeasurement.impl.enums.unit;

import org.unitsofmeasurement.impl.enums.quantity.QuantityFactory;
import org.unitsofmeasurement.impl.function.Multiplier;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.exception.IncommensurableException;
import javax.measure.exception.UnconvertibleException;
import javax.measure.function.UnitConverter;
import javax.measure.quantity.Dimensionless;

/**
 * @author Werner Keil
 * @version 1.1 ($Revision$), $Date$
 */
public enum DimensionlessUnit implements Unit<Dimensionless>, Multiplier {
    ONE("", 1.0); // reference Unit

    private final String description;
    private final double multFactor;

    private DimensionlessUnit(String name, double multF) {
        this.description = name;
        this.multFactor = multF;
    }

    public String getSymbol() {
        return description;
    }

    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<Dimensionless> getSystemUnit() {
		return ONE;
    }

    @Override
    public Map<? extends Unit<?>, Integer> getProductUnits() {
        Map<Unit<Dimensionless>, Integer> prodUnits = new HashMap<Unit<Dimensionless>, Integer>();
        prodUnits.put(ONE, Integer.valueOf(1));
        return prodUnits;
    }

    public static DimensionlessUnit getByName(String symbol) {
        return ONE;
    }

    public UnitConverter getConverterTo(Unit<Dimensionless> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    @Override
    public Unit<Dimensionless> alternate(String s) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

	@Override
	public String getName() {
		return name();
	}
    
    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

     public Unit<?> inverse() {
        return this;
    }

    @Override
    public Unit<Dimensionless> divide(double v) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    @Override
    public Unit<?> divide(Unit<?> unit) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public boolean isCompatible(Unit<?> that) {
        if (that instanceof DimensionlessUnit) return true;
        return false;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> tClass) {
        Unit<T> metricUnit = QuantityFactory.getInstance(tClass).getMetricUnit();
         if ((metricUnit == null) || metricUnit.isCompatible(this))
          return (Unit<T>) this;
           throw new ClassCastException("The unit: " + this //$NON-NLS-1$
               + " is not of parameterized type " + tClass); //$NON-NLS-1$
    }

    public Unit<Dimensionless> multiply(double factor) {
        return this;
    }

    public Unit<?> multiply(Unit<?> that) {
        return this;
    }

    public Unit<?> pow(int n) {
        return this;
    }

    public Unit<?> root(int n) {
        return this;
    }

    public Unit<Dimensionless> transform(UnitConverter operation) {
        return this;
    }

    @Override
    public Unit<Dimensionless> add(double v) {
        return this;
    }
}