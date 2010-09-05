/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import static org.unitsofmeasurement.DistanceUnit.REF_UNIT;

import org.unitsofmeasurement.AreaUnit;
import org.unitsofmeasurement.DistanceUnit;
import org.unitsofmeasurement.VolumeUnit;

/**
 * @author paul.morrison
 * 
 */
public class DistanceQuantity extends DimensionQuantity {

    public DistanceQuantity(double val, DistanceUnit un) {

	units = val;
	unit = un;
	scalar = val * unit.getMultFactor();
    }

    /*
     * Distance(double val) {
     * 
     * units = val; unit = m; // reference Unit scalar = val;
     * 
     * }
     */

    public DistanceQuantity add(DistanceQuantity d1) {
	return new DistanceQuantity(scalar + d1.scalar, REF_UNIT);
    }

    public DistanceQuantity subtract(DistanceQuantity d1) {
	return new DistanceQuantity(scalar - d1.scalar, REF_UNIT);
    }

    public boolean eq(DistanceQuantity d1) {
	return (scalar == d1.scalar);
    }

    public boolean ne(DistanceQuantity d1) {
	return (scalar != d1.scalar);
    }

    public boolean gt(DistanceQuantity d1) {
	return (scalar > d1.scalar);
    }

    public boolean lt(DistanceQuantity d1) {
	return (scalar < d1.scalar);
    }

    public boolean ge(DistanceQuantity d1) {
	return (scalar >= d1.scalar);
    }

    public boolean le(DistanceQuantity d1) {
	return (scalar <= d1.scalar);
    }

    public DistanceQuantity multiply(double v) {
	return new DistanceQuantity(scalar * v, REF_UNIT);
    }

    public DistanceQuantity divide(double v) {
	return new DistanceQuantity(scalar / v, REF_UNIT);
    }

    public DistanceQuantity convert(DistanceUnit newUnit) {
	return new DistanceQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    // mixed type operations
    public AreaQuantity multiply(DistanceQuantity d1) {
	return new AreaQuantity(scalar * d1.scalar, AreaUnit.REF_UNIT);
    }

    public VolumeQuantity multiply(AreaQuantity a1) {
	return new VolumeQuantity(scalar * a1.scalar, VolumeUnit.REF_UNIT);
    }
    // public Speed divide(TimeInterval t1) {
    // return new Speed(scalar /
    // t1.scalar, Speed.refUnit);
    // }
    // public TimeInterval divide(Speed s1) {
    // return new TimeInterval(scalar /
    // s1.scalar, TimeInterval.refUnit);
    // }

}