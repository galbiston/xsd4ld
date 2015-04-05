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

import xsd4ld.C ;

public class XSD_Token extends BaseString {
    /*
     * The value space of token is the set of strings that do not contain the
     * carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that
     * have no leading or trailing spaces (#x20) and that have no internal
     * sequences of two or more spaces. The lexical space of token is the set
     * of strings that do not contain the carriage return (#xD), line feed (#xA)
     * nor tab (#x9) characters, that have no leading or trailing spaces (#x20)
     * and that have no internal sequences of two or more spaces. The base
     * type of token is normalizedString.
     */
    public XSD_Token() {
        super(C.xsd_token, C.xsd_normalizedString) ;
    }
    
    @Override
    public boolean valid_NL_LF_TAB(String lex) {
        if ( ! test_valid_NL_LF_TAB(lex) )
            return false ;
        if ( lex.startsWith(" ") )
            return false ;
        if ( lex.endsWith(" ") )
            return false ;
        if ( lex.contains("  ") )   // 2 spaces
            return false ;
        return true ;
    }
}
