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

import java.util.regex.Pattern ;

import xsd4ld.XSDConst ;
import xsd4ld.XSDTypeRegex ;
import xsd4ld.lib.LangTag2 ;

public class XSD_Language extends BaseString {
    private Pattern pattern = XSDTypeRegex.getRegex(XSDConst.xsd_language) ;
    
    public XSD_Language() {
        super(XSDConst.xsd_language, XSDConst.xsd_token) ;
    }
    
    @Override
    protected String valueOrException(String lex) {
        if ( isValid(lex) )
            return LangTag2.canonical(lex) ;
        return null ;
    }

    @Override
    public boolean isValid(String lex) {
        //return null != LangTag2.parse(lex) ;
        return pattern.matcher(lex).matches() ;
    }
    
    @Override
    public Pattern getRegex() {
        return XSDTypeRegex.getRegex(XSDConst.xsd_language) ;
    }
}

