/**
 * Copyright (c) 2002-2012 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cypher.internal.commands

import expressions.{Literal, Subtract}
import org.junit.Test
import org.scalatest.Assertions
import org.neo4j.cypher.CypherTypeException

class SubtractTest extends Assertions {

  val m = Map[String, Any]()

  @Test def numbers() {
    val expr = Subtract(Literal(2), Literal(1))
    assert(expr(m) === 1)
  }

  @Test def strings() {
    val expr = Subtract(Literal("hello"), Literal("world"))
    intercept[CypherTypeException](expr(m))
  }

  @Test def stringPlusNumber() {
    val expr = Subtract(Literal("hello"), Literal(1))
    intercept[CypherTypeException](expr(m))
  }

  @Test def numberPlusString() {
    val expr = Subtract(Literal(1), Literal("world"))
    intercept[CypherTypeException](expr(m))
  }

  @Test def numberPlusBool() {
    val expr = Subtract(Literal("1"), Literal(true))
    intercept[CypherTypeException](expr(m))
  }
}