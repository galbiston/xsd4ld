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

package xsd4ld;

import static org.junit.Assert.fail ;
import org.junit.Test ;

/** test of integers and all derived types */
public class TestInteger {
    
    static void valid(String lex, XSDDatatype type) {
        test(lex, type, true);
    }
    
    static void test(String lex, XSDDatatype type, boolean valid) {
        if ( valid != type.isValid(lex) ) {
            if ( valid ) 
                fail("Unexpected invalid: "+type.getName()+" '"+lex+"'") ;
            else
                fail("Unexpected valid: "+type.getName()+" '"+lex+"'") ;
        }
    }
    
    static void invalid(String lex, XSDDatatype type) {
        test(lex, type, false);
    }
    
    
    @Test public void integer_01() { valid("0", XSD.xsdInteger) ; }
    @Test public void integer_02() { valid("+0", XSD.xsdInteger) ; }
    @Test public void integer_03() { valid("+0", XSD.xsdInteger) ; }
    
    @Test public void integer_04() { valid("9999999999999999999999999999999999999999999999999999999", XSD.xsdInteger) ; }
    @Test public void integer_05() { valid("+9999999999999999999999999999999999999999999999999999999", XSD.xsdInteger) ; }
    @Test public void integer_06() { valid("-9999999999999999999999999999999999999999999999999999999", XSD.xsdInteger) ; }

    

    
    
    @Test public void byte_01() { valid("0", XSD.xsdByte) ; }
    @Test public void byte_02() { invalid("999", XSD.xsdByte) ; }
    @Test public void byte_03() { valid("127", XSD.xsdByte) ; }
    @Test public void byte_04() { invalid("128", XSD.xsdByte) ; }
    @Test public void byte_05() { valid("-128", XSD.xsdByte) ; }
    @Test public void byte_06() { invalid("-129", XSD.xsdByte) ; }

    @Test public void ubyte_01() { valid("0", XSD.xsdUnsignedByte) ; }
    @Test public void ubyte_02() { invalid("999", XSD.xsdByte) ; }
    @Test public void ubyte_03() { valid("127", XSD.xsdByte) ; }
    @Test public void ubyte_04() { invalid("128", XSD.xsdByte) ; }
    @Test public void ubyte_05() { valid("-128", XSD.xsdByte) ; }
    @Test public void ubyte_06() { invalid("-129", XSD.xsdByte) ; }
    
}

