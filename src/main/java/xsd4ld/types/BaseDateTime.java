/**
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

package xsd4ld.types;

import javax.xml.datatype.XMLGregorianCalendar ;

import xsd4ld.C ;
import xsd4ld.XSDDatatype ;
import xsd4ld.lib.DateTimeStruct ;


/** The 7 component date/time model. */  
abstract class BaseDateTime extends XSDDatatype  {
    @FunctionalInterface interface Parser { DateTimeStruct parser(String s) ; } 
    DateTimeStruct struct ;
//    public String year ;
//    public String month ;
//    public String day ;
//    public String hour ;
//    public String minute ;
//    public String second ;  // Include fractional part
//    public String timezone ;
    /*
    year
    month
    day
    hour
    minute
    second
    timezone
    */
    private final Parser parser ;
    
    public BaseDateTime(String shortName, Parser parser) {
        super(shortName, C.xsd_atomic, null) ;
        this.parser = parser ;
    }

    @Override
    protected XMLGregorianCalendar valueOrException(String lex) {
        return C.factory.newXMLGregorianCalendar(lex) ;
    }

    @Override
    public boolean parse(String lex) {
        return parser.parser(lex) != null ;
    }

    @Override
    public boolean isValid(String lex) {
        return false ;
    }
}

