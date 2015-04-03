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

package generate;

import xsd4ld.XSDDatatype ;

public class BaseString extends XSDDatatype {

    public BaseString(String shortName, String baseType) { 
        super(shortName, baseType, null) ;
    }


    // Extra validate.
    // XSD_AbstractInteger?
    
    @Override
    public String value(String lex) {
        return lex ;
    }
    
    @Override
    public boolean parse(String lex) {
        return true ;
    }

    @Override
    public boolean isValid(String lex) {
        return true ;
    }
    
    public boolean isValidValue() {
        return true ; 
    }
    
//    @Override
//  public abstract int hashCode( );
//  @Override
//  public abstract boolean equals(Object other) ;
}


