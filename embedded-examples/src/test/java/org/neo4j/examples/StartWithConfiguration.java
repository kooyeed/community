/**
 * Licensed to Neo Technology under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Neo Technology licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.neo4j.examples;

import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import static org.junit.Assert.*;

public class StartWithConfiguration
{
    @Test
    public void test()
    {
        String pathToConfig = "src/test/resources/";
        // START SNIPPET: startDbWithConfig

        GraphDatabaseService graphDb = new GraphDatabaseFactory().
            newEmbeddedDatabaseBuilder( "target/database/location" ).
            loadPropertiesFromFile( pathToConfig + "neo4j.properties" ).
            newGraphDatabase();

        // END SNIPPET: startDbWithConfig
        assertNotNull( graphDb );
        graphDb.shutdown();
    }
}
