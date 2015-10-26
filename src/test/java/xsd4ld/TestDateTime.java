/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xsd4ld;

import static xsd4ld.LibTestXSD.* ;
import static xsd4ld.XSD.* ;
import org.junit.Test ;

/** Test for xsd:dateTime etc
 */
public class TestDateTime {

    @Test public void dateTimeStamp_01() {
        valid("2015-02-23T15:21:18Z", xsdDateTime) ;
        valid("2015-02-23T15:21:18Z", xsdDateTimeStamp) ;
    }

    @Test public void dateTimeStamp_02() {
        valid("2015-02-23T15:21:18", xsdDateTime) ;
        invalid("2015-02-23T15:21:18", xsdDateTimeStamp) ;
    }

    @Test public void dateTimeStamp_03() {
        invalid("2015-02-23Z", xsdDateTime) ;
        invalid("2015-02-23Z", xsdDateTimeStamp) ;
    }

    @Test public void dateTimeStamp_04() {
        valid("2015-02-23T15:21:18.665Z", xsdDateTime) ;
        valid("2015-02-23T15:21:18.665Z", xsdDateTimeStamp) ;
    }

    @Test public void dateTimeStamp_05() {
        valid("2015-02-23T15:21:18.665+00:00", xsdDateTime) ;
        valid("2015-02-23T15:21:18.665+00:00", xsdDateTimeStamp) ;
    }

    @Test public void dateTimeStamp_06() {
        invalid("2015-02-23T15:21:18.665+15:00", xsdDateTime) ;
        invalid("2015-02-23T15:21:18.665+15:00", xsdDateTimeStamp) ;
    }
    
    @Test public void gregorian_01() {
        valid("2015", xsdGYear) ;
        invalid("2015-02-23", xsdGYear) ;
    }
    
    @Test public void gregorian_02() {
        valid("2015-09", xsdGYearMonth) ;
        invalid("2015-02-23", xsdGYearMonth) ;
    }

    @Test public void gregorian_03() {
        invalid("2015-13", xsdGYearMonth) ;
        invalid("2015-02-23", xsdGYearMonth) ;
    }
    
}

