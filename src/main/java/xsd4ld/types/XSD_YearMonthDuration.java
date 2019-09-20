/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  See the NOTICE file distributed with this work for additional
 *  information regarding copyright ownership.
 */

package xsd4ld.types;

import java.time.Period;
import xsd4ld.ValueClass;

import xsd4ld.XSDConst;
import xsd4ld.XSDDatatype;
import xsd4ld.XSDTypeRegistry;

public class XSD_YearMonthDuration extends XSDDatatype {
    public XSD_YearMonthDuration() {
        super(XSDConst.xsd_yearMonthDuration, XSDConst.xsd_duration,ValueClass.DURATION, XSDTypeRegistry.getRegex(XSDConst.xsd_yearMonthDuration));
    }

    @Override
    protected Period valueOrException(String lex) {
        Period obj = Period.parse(lex);
        if ( obj == null )
            return null;
        // Must not have a D or T part.
        if ( lex.indexOf('D') != -1 || lex.indexOf('T') != -1 )
            throw new IllegalArgumentException("Not valid as xsd:yearMonthDuration: "+lex);
        return obj;
    }
}

