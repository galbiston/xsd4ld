/**
public  * Licensed to the Apache Software Foundation (ASF) under one
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

import javax.xml.datatype.Duration ;

import xsd4ld.XSDConst ;
import xsd4ld.XSDTypeRegex ;

public class XSD_YearMonthDuration extends BaseDuration {
    public XSD_YearMonthDuration() {
        //@@ check regex
        super(XSDConst.xsd_yearMonthDuration, XSDConst.xsd_duration, XSDTypeRegex.getRegex(XSDConst.xsd_duration)) ;
    }
    
    @Override
    protected Duration valueOrException(String lex) {
        Duration obj = super.valueOrException(lex) ;
        if ( obj == null )
            return null ;
        if ( lex.indexOf('D') != -1 || lex.indexOf('T') != -1 )
            throw new IllegalArgumentException("Not valid as xsd:yearMonthDuration: "+lex) ;
        return obj ;
    }
}

