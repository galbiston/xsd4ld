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

import xsd4ld.XSDConst ;
import xsd4ld.XSDDatatype ;
import xsd4ld.lib.DateTimeStruct ;

/** The 7 component date/time model.
 *  year / month / day / hour / minute / second / timezone
 */
abstract class BaseDateTime extends XSDDatatype  {
    @FunctionalInterface interface Parser { DateTimeStruct parse(String s) ; } 
    protected final Parser parser ;
    
    public BaseDateTime(String shortName, Parser parser) {
        super(shortName, XSDConst.xsd_atomic, null) ;
        this.parser = parser ;
    }

    @Override
    protected XMLGregorianCalendar valueOrException(String lex) {
        // checks syntax.
        if ( parse(lex) == null )
            return null ;
        // Checks values. 
        return XSDConst.factory.newXMLGregorianCalendar(lex) ;
    }

    protected DateTimeStruct parse(String lex) {
        // We use a different parser setup for each derived type. 
        try {
            return parser.parse(lex) ; 
        } catch (Exception ex) { return null ; }
    }
}

