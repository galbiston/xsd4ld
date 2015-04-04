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

import java.math.BigInteger ;

import xsd4ld.C ;
import xsd4ld.TypeRegistry ;
import xsd4ld.XSDDatatype ;

class BaseInteger extends XSDDatatype {
    private final BigInteger minValue ;
    private final BigInteger maxValue ;

    /**
     * @param shortName
     * @param baseType
     * @param minValue
     * @param maxValue
     * @param allowZero Is zero allow as a value?
     * @param signType  For non-zero values, what is the allowed sign? 
     */
    public BaseInteger(String shortName, String baseType, 
                       BigInteger minValue, BigInteger maxValue, 
                       boolean allowZero, SignType signType) {
        super(shortName, baseType, TypeRegistry.getRegex(C.xsd_integer)) ;
        this.minValue = minValue ;
        this.maxValue = maxValue ;
    }


    // Extra validate.
    // XSD_AbstractInteger?
    
    @Override
    public BigInteger value(String lex) {
        try {
            // This parses it
            return new BigInteger(lex) ;
        }
        catch (NumberFormatException ex) {
            return null ;
        }
    }
    
    @Override
    public boolean parse(String lex) {
        return regex.matcher(lex).matches() ;
    }

    //@@ Avoid double parsing.
    @Override
    public boolean isValid(String lex) {
        // No additional restrictions.
        boolean b = regex.matcher(lex).matches() ;
        if ( ! b )
            return false ;
        return isValidValue(lex) ;
    }
    
    public boolean isValidValue(String lex) {
        BigInteger v = value(lex) ; 
        if ( minValue != null && minValue.compareTo(v) > 0 )
            return false ;
        if ( maxValue != null && maxValue.compareTo(v) < 0 )
            return false ;
        return true ; 
    }

//    @Override
//  public abstract int hashCode( );
//  @Override
//  public abstract boolean equals(Object other) ;
}

