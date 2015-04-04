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

import java.math.BigDecimal ;

import xsd4ld.C ;
import xsd4ld.TypeRegistry ;
import xsd4ld.XSDDatatype ;

public class XSD_Decimal extends XSDDatatype {

    public XSD_Decimal() {
        super(C.xsd_decimal, C.xsd_atomic, TypeRegistry.getRegex(C.xsd_decimal)) ;
    }

    @Override
    protected Object valueOrException(String lex) {
        try {
            // This parses it
            return new BigDecimal(lex) ;
        }
        catch (NumberFormatException ex) {
            return null ;
        }
    }

    @Override
    public boolean parse(String lex) {
        return regex.matcher(lex).matches() ;
    }

    @Override
    public boolean isValid(String lex) {
        return parse(lex) ;
    }
}

