/*
 * Distributed as part of Scalala, a linear algebra library.
 *
 * Copyright (C) 2008- Daniel Ramage
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110 USA
 */
package scalala;
package tensor;
package dense;

import generic.Scalar;

import collection.generic.DomainMapCanMapValuesFrom;

import collection.dense.{DenseMutableDomainSeqLike,DenseMutableDomainSeq};

/**
 * A DenseVector is backed by an array of doubles.
 *
 * @author dramage
 */
class DenseVector[B](data : Array[B])
(implicit override val scalar : Scalar[B])
extends DenseMutableDomainSeq[B](data) with DenseMutableDomainSeqLike[B,DenseVector[B]]
with Vector[B] with VectorLike[B,DenseVector[B]] {
//  override def copy = new DenseVector(data.clone);
}

object DenseVector {
  /**
   * Static constructor that creates a dense vector of the given size
   * initialized by elements from the given values list (looping if
   * necessary).
   */
  def apply[B:Scalar:ClassManifest](size : Int)(values : B*) =
    new DenseVector(Array.tabulate(size)(i => values(i % values.length)));

  /** Tabulate a vector with the value at each offset given by the function. */
  def tabulate[B:Scalar:ClassManifest](size : Int)(f : (Int => B)) =
    new DenseVector(Array.tabulate(size)(f));

//  implicit object DenseVectorCanMapValuesFrom
//  extends DomainMapCanMapValuesFrom[DenseVector,Int,Double,Double,DenseVector] {
//    override def apply(from : DenseVector, fn : (Double=>Double)) = {
//      val data = new Array[Double](from.size);
//      var i = 0;
//      while (i < data.length) {
//        data(i) = fn(from.data(i));
//        i += 1;
//      }
//      new DenseVector(data);
//    }
//
//    override def apply(from : DenseVector, fn : ((Int,Double)=>Double)) = {
//      val data = new Array[Double](from.size);
//      var i = 0;
//      while (i < data.length) {
//        data(i) = fn(i, from.data(i));
//        i += 1;
//      }
//      new DenseVector(data);
//    }
//  }
}
