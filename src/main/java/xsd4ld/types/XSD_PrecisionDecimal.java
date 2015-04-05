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

import java.math.BigDecimal ;
import java.util.regex.Pattern ;

import xsd4ld.C ;
import xsd4ld.TypeRegistry ;
import xsd4ld.XSDDatatype ;

/** Precision Decimal : 
 *  <a href="http://www.w3.org/TR/xsd-precisionDecimal/">http://www.w3.org/TR/xsd-precisionDecimal/</a>
 */
public class XSD_PrecisionDecimal extends XSDDatatype {

    public XSD_PrecisionDecimal() {
        super(C.xsd_precisionDecimal, C.xsd_atomic, TypeRegistry.getRegex(C.xsd_precisionDecimal)) ;
    }

    Pattern exceptions = Pattern.compile("(\\+|-)?INF|NaN") ;
    
    @Override
    protected Object valueOrException(String lex) {
        if ( exceptions.matcher(lex).matches() ) 
            return new Double(BaseDoubleFloat.fix(lex)) ;
        return new BigDecimal(lex) ;
    }
}
